package com.itchina.distribution.constant;


import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>用户优惠券的状态</h1>
 */
public enum CouponStatus {

    USABLE("可用的", 1),
    USED("已使用的", 2),
    EXPIRED("过期的(未被使用的)", 3);

    /** 优惠券状态描述信息 */
    private String description;

    /** 优惠券状态编码 */
    private Integer code;

    /**
     * <h2>根据 code 获取到 CouponStatus</h2>
     * */
    public static CouponStatus of(Integer code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(code + " not exists")
                );
    }

    CouponStatus(String description, Integer code) {
        this.description = description;
        this.code = code;
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
