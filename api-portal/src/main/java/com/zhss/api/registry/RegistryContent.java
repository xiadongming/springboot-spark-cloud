package com.zhss.api.registry;

import com.zhss.api.entry.application.InvokeInfo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date: 2021/7/21 14:58
 * @Desc:
 */
public class RegistryContent {


    private static ConcurrentHashMap<String, InvokeInfo> registry = new ConcurrentHashMap<>();


    public static void setRegistry(String serviceId, InvokeInfo invokeInfo) {
        registry.put(serviceId, invokeInfo);
    }

    //查询
    public static  ConcurrentHashMap<String, InvokeInfo> getRegistry() {
        return registry;
    }

    //单例模式
    private RegistryContent() {

    }
}
