package com.itchina.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/4/10 7:39
 * @Desc:
 */
@RestController
public class HealthChackController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Registration registration;

    @RequestMapping(value = "/health", method = {RequestMethod.GET, RequestMethod.POST})
    public String health() {

        return "健康检查信息";
    }

    @RequestMapping(value = "/exception", method = {RequestMethod.GET, RequestMethod.POST})
    public String exception() {
        System.out.println("报错了，e= ");
        return "报错了，e=";
    }

    /**
     * 获取eureka server上的元信息
     */
    @RequestMapping(value = "/info", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Map<String, Object>> info() {
        /** 大约2分钟时间才能获取到注册信息 */

        List<ServiceInstance> instances = discoveryClient.getInstances(registration.getServiceId());
        List<Map<String, Object>> mapList = new ArrayList<>();
        instances.forEach(ins -> {
            Map<String, Object> info = new HashMap<>();
            info.put("servoiceId", ins.getServiceId());
            info.put("instanceId", ins.getInstanceId());
            info.put("port", ins.getPort());
            mapList.add(info);
        });

        return mapList;
    }

}
