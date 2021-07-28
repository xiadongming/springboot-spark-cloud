package com.zhss.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Date: 2021/7/27 15:08
 * @Desc:
 */
@MapperScan("com.zhss.stock.mapper")
@SpringBootApplication
public class SeataStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStockApplication.class, args);
    }
}
