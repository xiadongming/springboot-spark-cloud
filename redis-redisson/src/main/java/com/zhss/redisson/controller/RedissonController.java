package com.zhss.redisson.controller;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/7/6 7:00
 * @Desc:
 */
@RestController
public class RedissonController {

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping(value = "/redisson")
    public void test(){

        RMap<Object, Object> anfMap = redissonClient.getMap("anfMap");
        anfMap.put("abc","100");

        RMap<Object, Object> anfMap1 = redissonClient.getMap("anfMap");

        System.out.println(anfMap1.get("abc"));


    }

}
