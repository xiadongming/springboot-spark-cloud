package com.itchina.common.constant;


import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>产品线枚举</h1>
 */
public enum ProductLine implements CodeBaseEnum{

    DAMAO("大猫", 1),
    DABAO("大宝", 2);

    /** 产品线描述 */
    private String description;

    /** 产品线编码 */
    private Integer code;
    @Override
    public Integer code() {
        return code;
    }
    ProductLine(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    public static ProductLine of(Integer code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists!"));
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
