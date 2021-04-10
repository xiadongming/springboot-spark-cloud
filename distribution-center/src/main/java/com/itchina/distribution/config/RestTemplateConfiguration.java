package com.itchina.distribution.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Date: 2021/4/10 9:17
 * @Desc:   主要是ribbon在使用 restTmpalte
 */
@Configuration
public class RestTemplateConfiguration {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
