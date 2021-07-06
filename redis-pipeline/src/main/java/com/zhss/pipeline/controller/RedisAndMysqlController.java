package com.zhss.pipeline.controller;

import com.zhss.pipeline.entity.SysUser;
import com.zhss.pipeline.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date: 2021/7/5 17:39
 * @Desc:
 */
@RestController
public class RedisAndMysqlController {


    @Autowired
    private RedisService redisService;

    @GetMapping("/contro2")
    public void getTest(String key) throws InterruptedException {
        List<SysUser> allByUserIdAndStatus = redisService.findAllByUserIdAndStatus(key);
        System.out.println("allByUserIdAndStatus= " + allByUserIdAndStatus);
    }
}
