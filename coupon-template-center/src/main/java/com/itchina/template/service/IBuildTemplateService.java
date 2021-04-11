package com.itchina.template.service;


import com.itchina.common.exception.CouponException;
import com.itchina.common.vo.TemplateRequest;
import com.itchina.template.entity.CouponTemplate;

/**
 * <h1>构建优惠券模板接口定义</h1>
 */
public interface IBuildTemplateService {

    /**
     * <h2>创建优惠券模板</h2>
     * @param request {@link TemplateRequest} 模板信息请求对象
     * @return {@link CouponTemplate} 优惠券模板实体
     * */
    CouponTemplate buildTemplate(TemplateRequest request)  throws CouponException;
}
