package com.itchina;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.itchina.mapper")
@SpringBootApplication
public class SeckillApplicaztion {
    public static void main(String[] args) {
        SpringApplication.run(SeckillApplicaztion.class,args);
    }
}
