package com.itchina.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Date: 2021/4/28 8:56
 * @Desc:   hystrix是基于线程池隔离来做的，如果hystrix保护某个系统，那么所有对这个请求都会使用hystrix的线程资源
 */
@SpringBootApplication
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }
}
