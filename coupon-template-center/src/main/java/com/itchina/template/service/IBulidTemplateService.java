package com.itchina.template.service;

import com.itchina.common.vo.TemplateRequest;
import com.itchina.template.entity.CouponTemplate;

/**
 * @Date: 2021/4/9 7:33
 * @Desc: 创建优惠卷模板
 */
public interface IBulidTemplateService {
    /**
     * 优惠卷模板创建
     * @param  TemplateRequest 模板信息请求对象
     * @return ：CouponTemplate模板创建实体对象
     * */
    CouponTemplate  buildTemplate(TemplateRequest templateRequest);
}
