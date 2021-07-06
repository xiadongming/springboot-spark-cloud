package com.zhss.caffeine.init;

import java.util.function.Function;

/**
 * @Date: 2021/6/23 11:43
 * @Desc:
 */
public class CaffeineMappingFunction implements Function<String,String> {

    String key;

    public CaffeineMappingFunction(String key) {
        this.key = key;
    }

    @Override
    public String apply(String s) {
        return "123";
    }
}
