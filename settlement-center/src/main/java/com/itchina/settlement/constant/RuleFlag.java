package com.itchina.settlement.constant;


/**
 * <h1>规则类型枚举定义</h1>
 * Created by Qinyi.
 */
public enum RuleFlag {

    // 单类别优惠券定义
    MANJIAN("满减券的计算规则"),
    ZHEKOU("折扣券的计算规则"),
    LIJIAN("立减券的计算规则"),

    // 多类别优惠券定义
    MANJIAN_ZHEKOU("满减券 + 折扣券的计算规则");

    // TODO 更多优惠券类别的组合

    /** 规则描述 */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    RuleFlag(String description) {
        this.description = description;
    }
}
