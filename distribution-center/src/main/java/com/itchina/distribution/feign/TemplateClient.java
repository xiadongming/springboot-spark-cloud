package com.itchina.distribution.feign;

import com.itchina.common.vo.CommonResopnse;
import com.itchina.common.vo.CouponTemplateSDK;
import com.itchina.distribution.feign.hystrix.TemplateClientHystrix;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/4/10 14:00
 * @Desc: Feign和hystrix结合使用
 */
@FeignClient(value = "template-center",fallback = TemplateClientHystrix.class) //eureka中的应用名称
public interface TemplateClient {
   @RequestMapping(value = "/coupon-template/template/sdk/all")
   List<CouponTemplateSDK> findAllUsableTemplate();

    @RequestMapping(value = "/coupon-template/template/sdk/infos")
    Map<Integer, CouponTemplateSDK> findIds2TemplateSDK(@Param("ids") Collection<Integer> ids);

}
