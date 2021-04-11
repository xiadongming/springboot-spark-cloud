package com.itchina.common.constant;


import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>分发目标</h1>
 */
public enum DistributeTarget implements CodeBaseEnum{

    SINGLE("单用户", 1),
    MULTI("多用户", 2);

    /** 分发目标描述 */
    private String description;

    /** 分发目标编码 */
    private Integer code;
    @Override
    public Integer code() {
        return code;
    }
    DistributeTarget(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    public static DistributeTarget of(Integer code) {

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
