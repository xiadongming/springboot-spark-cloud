package com.guava;

/**
 * @Date: 2021/5/19 20:42
 * @Desc:
 */
public interface CacheService {
    //存
    void setCommonCache(String key,Object value);
    //取
    Object getCommonCache(String key);
}
