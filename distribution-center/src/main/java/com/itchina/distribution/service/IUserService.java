package com.itchina.distribution.service;


import com.itchina.common.vo.CouponTemplateSDK;
import com.itchina.common.vo.SettlementInfo;
import com.itchina.distribution.entity.Coupon;
import com.itchina.distribution.vo.AcquireTemplateRequest;

import java.util.List;

/**
 * <h1>用户服务相关的接口定义</h1>
 * 1. 用户三类状态优惠券信息展示服务
 * 2. 查看用户当前可以领取的优惠券模板 - coupon-template 微服务配合实现
 * 3. 用户领取优惠券服务
 * 4. 用户消费优惠券服务 - coupon-settlement 微服务配合实现
 */
public interface IUserService {

    /**
     * <h2>根据用户 id 和状态查询优惠券记录</h2>
     * @param userId 用户 id
     * @param status 优惠券状态
     * */
    List<Coupon> findCouponsByStatus(Long userId, Integer status) throws Exception;

    /**
     * <h2>根据用户 id 查找当前可以领取的优惠券模板</h2>
     * @param userId 用户 id
     * @return {@link CouponTemplateSDK}s
     * */
    List<CouponTemplateSDK> findAvailableTemplate(Long userId) throws Exception;

    /**
     * <h2>用户领取优惠券</h2>
     * @param request {@link AcquireTemplateRequest}
     * @return {@link Coupon}
     * */
    Coupon acquireTemplate(AcquireTemplateRequest request) throws Exception;

    /**
     * <h2>结算(核销)优惠券</h2>
     * */
   // SettlementInfo settlement(SettlementInfo info) throws Exception;
}
