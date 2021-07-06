package com.zhss.caceh.controller;

import com.google.common.cache.Cache;
import com.zhss.caceh.init.GuavaValueCallable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @Date: 2021/6/23 11:10
 * @Desc:
 */
@RestController
public class GuavaController {

    @Autowired
    private Cache cache;

    @GetMapping("/guava")
    public Object guavaTest(String key) throws ExecutionException {
        /**
         * 如果没有数据，则回调 GuavaValueCallable 去加载数据
         */
        cache.getIfPresent("");
        Object value = cache.get(key, new GuavaValueCallable(key));
        System.out.println("controller==value=" + value);
        return "successful";
    }
}
