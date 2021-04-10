package com.itchina.distribution.feign.ribbon;

import com.itchina.distribution.config.RestTemplateConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Date: 2021/4/10 20:36
 * @Desc: 对比ribbon的hystrix功能
 */
@Service
public class RibbonHystrixServiceImpl {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public Object hiHystric(){
        return "successful";
    }
    public Object hiError(){
        return "服务不可用";
    }
}
