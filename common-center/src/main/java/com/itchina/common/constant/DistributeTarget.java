package com.itchina.common.constant;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @Date: 2021/4/8 21:24
 * @Desc: 分发目标
 */
public enum DistributeTarget {

    SINGLE("单用户", 1),
    MULTI("多用户", 2);
    /**
     * 分发目标描述
     */
    private String description;
    /**
     * 分发目标编码
     */
    private Integer code;

    DistributeTarget(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    public static DistributeTarget of(Integer code) {
        Objects.requireNonNull(code);
        Stream<DistributeTarget> values = Stream.of(values());
        DistributeTarget distributeTarget = values.filter(bean -> bean.code.equals(code)).findAny().orElseThrow(() -> new IllegalArgumentException(code + " >> 不存在"));
        return distributeTarget;
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
