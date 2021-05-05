package com.itchina.hystrix.config;

import com.itchina.hystrix.filter.HystrixRequestContextFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @Date: 2021/5/5 14:20
 * @Desc:
 */
@Configuration
public class ConfigFile {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean(new HystrixRequestContextFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        return filterFilterRegistrationBean;

    }

}
