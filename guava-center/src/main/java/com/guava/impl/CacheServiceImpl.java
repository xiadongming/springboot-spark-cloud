package com.guava.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.guava.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @Date: 2021/5/19 20:42
 * @Desc:
 */
@Service
public class CacheServiceImpl implements CacheService {


    @Autowired
    private Cache<String,Object> cache ;


    @Override
    public void setCommonCache(String key, Object value) {
        cache.put(key,value);
    }

    @Override
    public Object getCommonCache(String key) {
        return cache.getIfPresent(key);
    }
}
