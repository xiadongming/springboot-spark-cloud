package com.itchina.common.constant;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @Date: 2021/4/8 21:19
 * @Desc: 产品线枚举
 * 每一个优惠卷都属于一个产品线
 */
public enum ProductLine {

    DAMAO("大猫", 1),
    DABAO("大宝", 2);

    /**
     * 描述
     */
    private String description;
    /**
     * 产品线编码
     */
    private Integer code;

    ProductLine(String description, Integer code) {
        this.description = description;
        this.code = code;
    }
    public static ProductLine of(Integer code) {
        Objects.requireNonNull(code);
        Stream<ProductLine> values = Stream.of(values());
        //ProductLine productLine = values.filter(bean -> bean.code.equals(code)).findAny().orElseThrow(() -> new IllegalArgumentException(code + " >> 不存在"));
        ProductLine productLine = values.filter(bean -> bean.code.equals(code)).findAny().orElse(ProductLine.DABAO);
        return productLine;
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
