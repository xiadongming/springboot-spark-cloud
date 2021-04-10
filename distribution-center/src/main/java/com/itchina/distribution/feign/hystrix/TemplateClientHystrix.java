package com.itchina.distribution.feign.hystrix;

import com.itchina.common.vo.CouponTemplateSDK;
import com.itchina.distribution.feign.TemplateClient;
import com.itchina.distribution.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Date: 2021/4/10 20:03
 * @Desc: 针对优惠卷模板的feign接口熔断降级策略
 *       注意：hystrix要求方法名和feign的方法名相同，最简单的办法是实现feign的接口
 */
@Component
public class TemplateClientHystrix implements TemplateClient {
    final Logger logger = LoggerFactory.getLogger(TemplateClientHystrix.class);

    @Override
    public List<CouponTemplateSDK> findAllUsableTemplate() {
        logger.error("feign降级：TemplateClientHystrix.findAllUsableTemplate() ，当前服务不可用" );

        /** 返回空的数据 */
        return new ArrayList<>();
    }

    @Override
    public Map<Integer, CouponTemplateSDK> findIds2TemplateSDK(Collection<Integer> ids) {
        logger.error("feign降级：TemplateClientHystrix.findIds2TemplateSDK() ，当前服务不可用" );


        /** 返回空的数据 */
        return new HashMap<>();
    }
}
