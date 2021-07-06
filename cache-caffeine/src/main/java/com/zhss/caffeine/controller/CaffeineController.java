package com.zhss.caffeine.controller;

import com.github.benmanes.caffeine.cache.Cache;
import com.zhss.caffeine.init.CaffeineMappingFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/6/23 11:35
 * @Desc:
 */
@RestController
public class CaffeineController {

    @Autowired
    private Cache<String, String> cache;

    @GetMapping("/caffeine")
    public Object caffeineTest(String key) {
        /**
         * 没有值的时候，去调用 CaffeineMappingFunction 的逻辑去获取
         */
        String s = cache.get(key, new CaffeineMappingFunction(key));

        return s;
    }


    @GetMapping("/caffeine2")
    public Object caffeineTest2(String key) {

        cache.put(key,"原始值");
        String origin = cache.get(key, new CaffeineMappingFunction(key));

        return origin;
    }


}
