package com.itchina;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @Date: 2021/4/10 9:11
 * @Desc: 分发系统启动入口
 */
@MapperScan("com.itchina.distribution.mapper")
@EnableFeignClients   //微服务调用
@EnableEurekaClient
@EnableCircuitBreaker //熔断器
@SpringBootApplication
public class DistributionApplication {
    public static void main(String[] args) {
        SpringApplication.run(DistributionApplication.class, args);
    }


}
