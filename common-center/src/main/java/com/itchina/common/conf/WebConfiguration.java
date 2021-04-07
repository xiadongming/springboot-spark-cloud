package com.itchina.common.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Date: 2021/4/7 22:05
 * @Desc: http消息转换器
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * http消息转换器
     * 将java的实体类对象，转换为http的输入输出流(json数据格式)
     * */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
