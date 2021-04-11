package com.itchina.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/4/11 19:56
 * @Desc:
 */
@RestController
public class JmeterController {


    @RequestMapping(value = "/jmeter",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getTest(){

        System.out.println("200,time " + System.currentTimeMillis() + ", " +Thread.currentThread().getName());

        return "successful";
    }

}
