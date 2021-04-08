package com.itchina.common.constant;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @Date: 2021/4/8 21:31
 * @Desc: 优惠卷有效期类型
 */
public enum  PeriodType {

    REGULAR("固定的(固定日期)",1),
    SHIFT("变动的(以领取之日开始计算)",2);

    /**
     * 描述
     */
    private String description;
    /**
     * 有效期编码
     */
    private Integer code;

    PeriodType(String description, Integer code) {
        this.description = description;
        this.code = code;
    }
    public static PeriodType of(Integer code) {
        Objects.requireNonNull(code);
        Stream<PeriodType> values = Stream.of(values());
        PeriodType periodType = values.filter(bean -> bean.code.equals(code)).findAny().orElseThrow(() -> new IllegalArgumentException(code + " >> 不存在"));
        return periodType;
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
