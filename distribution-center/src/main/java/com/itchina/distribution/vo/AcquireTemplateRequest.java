package com.itchina.distribution.vo;

import com.itchina.common.vo.CouponTemplateSDK;

/**
 * <h1>获取优惠券请求对象定义</h1>
 */
public class AcquireTemplateRequest {

    /** 用户 id */
    private Long userId;

    /** 优惠券模板信息 */
    private CouponTemplateSDK templateSDK;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CouponTemplateSDK getTemplateSDK() {
        return templateSDK;
    }

    public void setTemplateSDK(CouponTemplateSDK templateSDK) {
        this.templateSDK = templateSDK;
    }
}
