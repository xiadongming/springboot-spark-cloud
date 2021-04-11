package com.itchina.template.service.impl;

import com.itchina.common.exception.CouponException;
import com.itchina.common.vo.CouponTemplateSDK;
import com.itchina.template.entity.CouponTemplate;
import com.itchina.template.mapper.CouponTemplateMapper;
import com.itchina.template.service.ITemplateBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <h1>优惠券模板基础服务接口实现</h1>
 * Created by Qinyi.
 */
@Service
public class TemplateBaseServiceImpl implements ITemplateBaseService {

    /** CouponTemplate Dao */
    @Autowired
    private  CouponTemplateMapper couponTemplateMapper;

    /**
     * <h2>根据优惠券模板 id 获取优惠券模板信息</h2>
     * @param id 模板 id
     * @return {@link CouponTemplate} 优惠券模板实体
     */
    @Override
    public CouponTemplate buildTemplateInfo(Integer id) throws CouponException {

        Optional<CouponTemplate> template = Optional.ofNullable(couponTemplateMapper.selectTemplateById(id));
        if (!template.isPresent()) {
            throw new CouponException("Template Is Not Exist: " + id);
        }

        return template.get();
    }

    /**
     * <h2>查找所有可用的优惠券模板</h2>
     * @return {@link CouponTemplateSDK}s
     */
    @Override
    public List<CouponTemplateSDK> findAllUsableTemplate() {

        List<CouponTemplate> templates =  couponTemplateMapper.selectAll();

        return templates.stream()
                .map(this::template2TemplateSDK).collect(Collectors.toList());
    }

    /**
     * <h2>获取模板 ids 到 CouponTemplateSDK 的映射</h2>
     * @param ids 模板 ids
     * @return Map<key: 模板 id, value: CouponTemplateSDK>
     */
    @Override
    public Map<Integer, CouponTemplateSDK> findIds2TemplateSDK( Collection<Integer> ids) {
        List<CouponTemplate> templates = new ArrayList<>();
        if(!CollectionUtils.isEmpty(ids)){
            for (Integer id : ids) {
                templates.add( couponTemplateMapper.selectTemplateById(id));
            }
        }
        return templates.stream().map(this::template2TemplateSDK).collect(Collectors.toMap(CouponTemplateSDK::getId, Function.identity()));
    }

    /**
     * <h2>将 CouponTemplate 转换为 CouponTemplateSDK</h2>
     * */
    private CouponTemplateSDK template2TemplateSDK(CouponTemplate template) {

        return new CouponTemplateSDK(
                template.getId(),
                template.getName(),
                template.getLogo(),
                template.getDesc(),
                String.valueOf(template.getCategoryCode()),
                Integer.parseInt(template.getProductLineCode()),
                template.getKey(),  // 并不是拼装好的 Template Key
                Integer.parseInt(template.getTargetCode()),
                template.getRuleCode()
        );
    }
}
