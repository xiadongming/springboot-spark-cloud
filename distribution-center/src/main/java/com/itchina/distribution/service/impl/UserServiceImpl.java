package com.itchina.distribution.service.impl;

import com.alibaba.fastjson.JSON;
import com.itchina.common.constant.Constant;
import com.itchina.common.vo.CouponTemplateSDK;
import com.itchina.common.vo.SettlementInfo;
import com.itchina.distribution.constant.CouponStatus;
import com.itchina.distribution.entity.Coupon;
import com.itchina.distribution.feign.TemplateClient;
import com.itchina.distribution.mapper.CouponMapper;
import com.itchina.distribution.service.IRedisService;
import com.itchina.distribution.service.IUserService;
import com.itchina.distribution.vo.AcquireTemplateRequest;
import com.itchina.distribution.vo.CouponClassify;
import com.itchina.distribution.vo.CouponKafkaMessage;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h1>用户服务相关的接口实现</h1>
 * 所有的操作过程, 状态都保存在 Redis 中, 并通过 Kafka 把消息传递到 MySQL 中
 * 为什么使用 Kafka, 而不是直接使用 SpringBoot 中的异步处理 ?
 */
@Service
public class UserServiceImpl implements IUserService {
    final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private  CouponMapper couponMapper;

    /** Redis 服务 */
    @Autowired
    private IRedisService redisService;

    /** 模板微服务客户端 */
    @Autowired
    private TemplateClient templateClient;

    /** 结算微服务客户端 */
    @Autowired
    private SettlementClient settlementClient;

    /** Kafka 客户端 */
    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;


    /**
     * <h2>根据用户 id 和状态查询优惠券记录</h2>
     * @param userId 用户 id
     * @param status 优惠券状态
     * @return {@link Coupon}s
     */
    @Override
    public List<Coupon> findCouponsByStatus(Long userId, Integer status) throws Exception {

        List<Coupon> curCached = redisService.getCachedCoupons(userId, status);
        List<Coupon> preTarget;

        if (CollectionUtils.isNotEmpty(curCached)) {
            logger.debug("coupon cache is not empty: {}, {}", userId, status);
            preTarget = curCached;
        } else {
            logger.debug("coupon cache is empty, get coupon from db: {}, {}",
                    userId, status);
            List<Coupon> dbCoupons = couponMapper.findAllByUserIdAndStatus(userId, status );
            // 如果数据库中没有记录, 直接返回就可以, Cache 中已经加入了一张无效的优惠券
            if (CollectionUtils.isEmpty(dbCoupons)) {
                logger.debug("current user do not have coupon: {}, {}", userId, status);
                return dbCoupons;
            }

            // 填充 dbCoupons的 templateSDK 字段
            Map<Integer, CouponTemplateSDK> id2TemplateSDK =templateClient.findIds2TemplateSDK(dbCoupons.stream().map(Coupon::getTemplateId).collect(Collectors.toList()));
            dbCoupons.forEach(
                    dc -> dc.setTemplateSDK(
                            id2TemplateSDK.get(dc.getTemplateId())
                    )
            );
            // 数据库中存在记录
            preTarget = dbCoupons;
            // 将记录写入 Cache
            redisService.addCouponToCache(userId, preTarget, status);
        }

        // 将无效优惠券剔除
        preTarget = preTarget.stream().filter(c -> c.getId() != -1).collect(Collectors.toList());
        // 如果当前获取的是可用优惠券, 还需要做对已过期优惠券的延迟处理
        if (CouponStatus.of(status) == CouponStatus.USABLE) {
            CouponClassify classify = CouponClassify.classify(preTarget);
            // 如果已过期状态不为空, 需要做延迟处理
            if (CollectionUtils.isNotEmpty(classify.getExpired())) {
                logger.info("Add Expired Coupons To Cache From FindCouponsByStatus: " + "{}, {}", userId, status);
                redisService.addCouponToCache(userId, classify.getExpired(), CouponStatus.EXPIRED.getCode()  );
                // 发送到 kafka 中做异步处理
                kafkaTemplate.send( Constant.TOPIC, JSON.toJSONString(new CouponKafkaMessage( CouponStatus.EXPIRED.getCode(),classify.getExpired().stream().map(Coupon::getId).collect(Collectors.toList()))));
            }

            return classify.getUsable();
        }

        return preTarget;
    }

    /**
     * <h2>根据用户 id 查找当前可以领取的优惠券模板</h2>
     * @param userId 用户 id
     * @return {@link CouponTemplateSDK}s
     */
    @Override
    public List<CouponTemplateSDK> findAvailableTemplate(Long userId) throws Exception {

        long curTime = new Date().getTime();
        List<CouponTemplateSDK> templateSDKS =templateClient.findAllUsableTemplate();

        logger.debug("Find All Template(From TemplateClient) Count: {}", templateSDKS.size());

        // 过滤过期的优惠券模板
        templateSDKS = templateSDKS.stream().filter(t -> t.getRule().getExpiration().getDeadline() > curTime ).collect(Collectors.toList());

        logger.info("Find Usable Template Count: {}", templateSDKS.size());

        // key 是 TemplateId
        // value 中的 left 是 Template limitation, right 是优惠券模板
        Map<Integer, Pair<Integer, CouponTemplateSDK>> limit2Template = new HashMap<>(templateSDKS.size());
        templateSDKS.forEach( t -> limit2Template.put( t.getId(), Pair.of(t.getRule().getLimitation(), t) )        );

        List<CouponTemplateSDK> result = new ArrayList<>(limit2Template.size());
        List<Coupon> userUsableCoupons = findCouponsByStatus(userId, CouponStatus.USABLE.getCode());

        logger.debug("Current User Has Usable Coupons: {}, {}", userId,userUsableCoupons.size());

        // key 是 TemplateId
        Map<Integer, List<Coupon>> templateId2Coupons = userUsableCoupons.stream().collect(Collectors.groupingBy(Coupon::getTemplateId));

        // 根据 Template 的 Rule 判断是否可以领取优惠券模板
        limit2Template.forEach((k, v) -> {
            int limitation = v.getLeft();
            CouponTemplateSDK templateSDK = v.getRight();
            if (templateId2Coupons.containsKey(k)
                    && templateId2Coupons.get(k).size() >= limitation) {
                return;
            }
            result.add(templateSDK);
        });
        return result;
    }

    /**
     * <h2>用户领取优惠券</h2>
     * 1. 从 TemplateClient 拿到对应的优惠券, 并检查是否过期
     * 2. 根据 limitation 判断用户是否可以领取
     * 3. save to db
     * 4. 填充 CouponTemplateSDK
     * 5. save to cache
     * @param request {@link AcquireTemplateRequest}
     * @return {@link Coupon}
     */
    @Override
    public Coupon acquireTemplate(AcquireTemplateRequest request) throws Exception {

        Map<Integer, CouponTemplateSDK> id2Template =templateClient.findIds2TemplateSDK(Collections.singletonList(request.getTemplateSDK().getId()));

        // 优惠券模板是需要存在的
        if (id2Template.size() <= 0) {
            logger.error("Can Not Acquire Template From TemplateClient: {}", request.getTemplateSDK().getId());
            throw new Exception("Can Not Acquire Template From TemplateClient");
        }

        // 用户是否可以领取这张优惠券
        List<Coupon> userUsableCoupons = findCouponsByStatus(request.getUserId(), CouponStatus.USABLE.getCode() );
        Map<Integer, List<Coupon>> templateId2Coupons = userUsableCoupons.stream().collect(Collectors.groupingBy(Coupon::getTemplateId));

        if (templateId2Coupons.containsKey(request.getTemplateSDK().getId())&& templateId2Coupons.get(request.getTemplateSDK().getId()).size() >= request.getTemplateSDK().getRule().getLimitation()) {
            logger.error("Exceed Template Assign Limitation: {}",request.getTemplateSDK().getId());
            throw new Exception("Exceed Template Assign Limitation");
        }

        // 尝试去获取优惠券码
        String couponCode = redisService.tryToAcquireCouponCodeFromCache(
                request.getTemplateSDK().getId()
        );
        if (StringUtils.isEmpty(couponCode)) {
            logger.error("Can Not Acquire Coupon Code: {}", request.getTemplateSDK().getId());
            throw new Exception("Can Not Acquire Coupon Code");
        }

        Coupon newCoupon = new Coupon( request.getTemplateSDK().getId(), request.getUserId(), couponCode,"1" );
        //newCoupon = couponMapper.save(newCoupon);

        // 填充 Coupon 对象的 CouponTemplateSDK, 一定要在放入缓存之前去填充
        newCoupon.setTemplateSDK(request.getTemplateSDK());

        // 放入缓存中
        redisService.addCouponToCache(
                request.getUserId(),
                Collections.singletonList(newCoupon),
                CouponStatus.USABLE.getCode()
        );

        return newCoupon;
    }

    /**
     * <h2>结算(核销)优惠券</h2>
     * 这里需要注意, 规则相关处理需要由 Settlement 系统去做, 当前系统仅仅做
     * 业务处理过程(校验过程)
     * @param info {@link SettlementInfo}
     * @return {@link SettlementInfo}
     */
   /* @Override
    public SettlementInfo settlement(SettlementInfo info) throws Exception {

        // 当没有传递优惠券时, 直接返回商品总价
        List<SettlementInfo.CouponAndTemplateInfo> ctInfos =  info.getCouponAndTemplateInfos();
        if (CollectionUtils.isEmpty(ctInfos)) {

            logger.info("Empty Coupons For Settle.");
            double goodsSum = 0.0;

            for (GoodsInfo gi : info.getGoodsInfos()) {
                goodsSum += gi.getPrice() + gi.getCount();
            }

            // 没有优惠券也就不存在优惠券的核销, SettlementInfo 其他的字段不需要修改
            info.setCost(retain2Decimals(goodsSum));
        }

        // 校验传递的优惠券是否是用户自己的
        List<Coupon> coupons = findCouponsByStatus( info.getUserId(), CouponStatus.USABLE.getCode() );
        Map<Integer, Coupon> id2Coupon = coupons.stream()
                .collect(Collectors.toMap(
                        Coupon::getId,
                        Function.identity()
                ));
        if (MapUtils.isEmpty(id2Coupon) || !CollectionUtils.isSubCollection(
                ctInfos.stream().map(SettlementInfo.CouponAndTemplateInfo::getId)
                .collect(Collectors.toList()), id2Coupon.keySet()
        )) {
            logger.info("{}", id2Coupon.keySet());
            logger.info("{}", ctInfos.stream()
                    .map(SettlementInfo.CouponAndTemplateInfo::getId)
                    .collect(Collectors.toList()));
            logger.error("User Coupon Has Some Problem, It Is Not SubCollection" +
                    "Of Coupons!");
            throw new Exception("User Coupon Has Some Problem, It Is Not SubCollection Of Coupons!");
        }

        logger.debug("Current Settlement Coupons Is User's: {}", ctInfos.size());

        List<Coupon> settleCoupons = new ArrayList<>(ctInfos.size());
        ctInfos.forEach(ci -> settleCoupons.add(id2Coupon.get(ci.getId())));

        // 通过结算服务获取结算信息
        SettlementInfo processedInfo = settlementClient.computeRule(info).getData();
        if (processedInfo.getEmploy() && CollectionUtils.isNotEmpty(processedInfo.getCouponAndTemplateInfos())) {
            logger.info("Settle User Coupon: {}, {}", info.getUserId(),  JSON.toJSONString(settleCoupons));
            // 更新缓存
            redisService.addCouponToCache(info.getUserId(),  settleCoupons,   CouponStatus.USED.getCode()
            );
            // 更新 db
            kafkaTemplate.send( Constant.TOPIC, JSON.toJSONString(new CouponKafkaMessage( CouponStatus.USED.getCode(),settleCoupons.stream().map(Coupon::getId).collect(Collectors.toList()) )));
        }

        return processedInfo;
    }
*/
    /**
     * <h2>保留两位小数</h2>
     * */
    private double retain2Decimals(double value) {

        // BigDecimal.ROUND_HALF_UP 代表四舍五入
        return new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
