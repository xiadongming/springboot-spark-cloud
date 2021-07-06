package com.zhss.controller;

import com.zhss.entity.UserInfo;
import com.zhss.service.SnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/6/25 17:00
 * @Desc:
 */
@RestController
public class SnaController {
    List<UserInfo> userInfoList = new ArrayList<>();

    @Autowired
    SnaService snaService;
    int a = 0;

    @GetMapping("/contro")
    public String getTest() throws InterruptedException {
        while (true) {
            Thread.sleep(200);
            UserInfo userInfo = new UserInfo("北京市1", "北京市2", "北京市3");
            userInfoList.add(userInfo);
            a++;
            System.out.println("a= " + a + ",threadName= " + Thread.currentThread().getName());

        }
        //return "successful";
    }
}
