package com.itchina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @Date: 2021/4/7 8:38
 * @Desc: EnableZuulServer :代表当前服务是zuul网关服务
 *        SpringCloudApplication ：组合注解，包含服务发现 和 熔断
 *                                服务发现：EnableDiscoveryClient作用同  EnableEurekaClient
 *                                熔断：   EnableCircuitBreaker
 */
@EnableZuulServer
@SpringCloudApplication
public class ZuulGateWayApplicaztion {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateWayApplicaztion.class,args);
    }
}
