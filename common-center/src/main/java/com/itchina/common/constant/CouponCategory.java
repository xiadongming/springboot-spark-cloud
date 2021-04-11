package com.itchina.common.constant;


import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>优惠券分类</h1>
 */

public enum CouponCategory implements CodeBaseEnum{

    MANJIAN("满减券", 001),
    ZHEKOU("折扣券", 002),
    LIJIAN("立减券", 003);

    /** 优惠券描述(分类) */
    private String description;

    /** 优惠券分类编码 */
    private Integer code;

    @Override
    public Integer code() {
        return code;
    }
    CouponCategory(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    public static CouponCategory of(String code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + "  >>>>不存在"));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
