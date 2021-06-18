package com.guava.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Date: 2021/5/19 20:43
 * @Desc:
 */
@Configuration
public class GuavaConfig {

    @Bean
    public Cache<String,Object> cache(){
        Cache<String,Object>  commonCache= CacheBuilder.newBuilder()
                //设置缓存容器的初始化容量为10（可以存10个键值对）
                .initialCapacity(10)
                //最大缓存容量是100,超过100后会安装LRU策略-最近最少使用，具体百度-移除缓存项
                .maximumSize(100)
                //设置写入缓存后1分钟后过期
                .expireAfterWrite(60, TimeUnit.SECONDS).build();
        return commonCache;
    }
}
