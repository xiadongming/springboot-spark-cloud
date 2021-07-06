package com.zhss.pipeline.entity;


import java.util.Date;

/**
 * <h1>优惠券(用户领取的优惠券记录)实体表</h1>
 */
public class Coupon {

    /** 自增主键 */
    private Integer id;

    /** 关联优惠券模板的主键(逻辑外键) */
    private Integer templateId;

    /** 领取用户 */
    private Long userId;

    /** 优惠券码 */
    private String couponCode;

    /** 领取时间 */
    private Date assignTime;

    /** 优惠券状态 */
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", templateId=" + templateId +
                ", userId=" + userId +
                ", couponCode='" + couponCode + '\'' +
                ", assignTime=" + assignTime +
                ", status='" + status + '\'' +
                '}';
    }
}
