package com.itchina.common.constant;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @Date: 2021/4/8 21:11
 * @Desc: 优惠卷分类
 */
public enum CouponCategory {

    MANJIAN("满减卷", "001"),
    ZHEKOU("折扣卷", "002"),
    LIJIAN("立减宽", "003");
    /**
     * 描述
     */
    private String description;
    /**
     * 优惠卷编码
     */
    private String code;

    CouponCategory(String description, String code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
