package com.zhss.caceh.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Date: 2021/6/23 10:55
 * @Desc:
 */
@Configuration
@EnableCaching
public class GuavaCacheConfig {


    @Bean
    public Cache<String, String> cache() {
        Cache<String, String> commonCache = CacheBuilder.newBuilder()
                //设置缓存容器的初始化容量为10（可以存10个键值对）
                .initialCapacity(10)
                //最大缓存容量是100,超过100后会安装LRU策略-最近最少使用，具体百度-移除缓存项
                .maximumSize(100)
                //设置写入缓存后1分钟后过期
                .expireAfterWrite(60, TimeUnit.SECONDS)
                ////设置读写缓存后n秒钟过期,实际很少用到,类似于expireAfterWrite
                //.expireAfterAccess(60,TimeUnit.SECONDS)
                .build();
        return commonCache;
    }
}
