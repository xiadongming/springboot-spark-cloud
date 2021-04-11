package com.itchina.common.constant;


import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>有效期类型</h1>
 */
public enum PeriodType  implements CodeBaseEnum{

    REGULAR("固定的(固定日期)", 1),
    SHIFT("变动的(以领取之日开始计算)", 2);

    /** 有效期描述 */
    private String description;

    /** 有效期编码 */
    private Integer code;
    @Override
    public Integer code() {
        return code;
    }
    PeriodType(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    public static PeriodType of(Integer code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " >>>>不存在"));
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
