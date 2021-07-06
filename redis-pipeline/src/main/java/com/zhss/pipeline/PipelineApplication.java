package com.zhss.pipeline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Date: 2021/6/18 15:10
 * @Desc:
 */
@MapperScan("com.zhss.pipeline.mapper")
@SpringBootApplication
public class PipelineApplication {

    public static void main(String[] args) {

        SpringApplication.run(PipelineApplication.class);

    }
}
