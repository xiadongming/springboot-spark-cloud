package com.itchina.common.constant;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Date: 2021/4/11 10:11
 * @Desc:
 */
public interface CodeBaseEnum {
    Integer  code();
    static <E extends Enum<?> & CodeBaseEnum> Optional<E> codeOf(Class<E> enumClass, int code) {
        return Arrays.stream(enumClass.getEnumConstants()).filter(e -> e.code() == code).findAny();
    }
}
