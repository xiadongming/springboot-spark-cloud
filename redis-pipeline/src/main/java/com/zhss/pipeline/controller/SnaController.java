package com.zhss.pipeline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2021/6/25 17:00
 * @Desc:
 */
@RestController
public class SnaController {
    Map<String, String> mapTotal = new HashMap<>();
    int a = 0;

    @GetMapping("/contro")
    public void getTest() throws InterruptedException {

        while (true) {
            Thread.sleep(2000);
            a++;
            Map<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("A" + a, "value" + a);
            mapTotal.putAll(stringStringHashMap);
        }
    }

}
