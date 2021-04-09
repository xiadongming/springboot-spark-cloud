package com.itchina.template.service;

import com.itchina.template.entity.CouponTemplate;

/**
 * @Date: 2021/4/9 7:50
 * @Desc: 异步服务接口，
 *
 */
public interface IAsyncService {
    /**
     * 根据模板，异步创建优惠卷码
     * */
    void asyncContructCouponByTemplate(CouponTemplate couponTemplate);
}
