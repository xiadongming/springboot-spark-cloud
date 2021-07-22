package com.zhss.api.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2021/7/22 15:22
 * @Desc:
 */
public class BeanCoperUtils {
    private static Map<String, BeanCopier> copierCacheMap = new HashMap<>();
    public static void copyProperties(Object source, Object target) {
        String key = generaKey(source.getClass().toString(), target.getClass().toString());
        BeanCopier beanCopier = null;
        if (!copierCacheMap.containsKey(key)) {
            synchronized (BeanCoperUtils.class) {
                if (!copierCacheMap.containsKey(key)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    copierCacheMap.put(key, beanCopier);
                }
            }
        } else {
            beanCopier = copierCacheMap.get(key);
        }
        beanCopier.copy(source, target, null);
    }

    private static String generaKey(String sourceKey, String targetKey) {
        return sourceKey + targetKey;
    }
}
