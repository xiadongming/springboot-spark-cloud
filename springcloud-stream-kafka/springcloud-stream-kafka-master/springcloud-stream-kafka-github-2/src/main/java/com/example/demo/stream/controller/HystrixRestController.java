package com.example.demo.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.stream.service.MessageSender;

@RestController
@RequestMapping("/web")
public class HystrixRestController {

    @Autowired
    private MessageSender messageSender;


    @RequestMapping(value = "/html", method = RequestMethod.GET)
    public void getGreetings() {
        System.out.println("===============stream======================");
        messageSender.send("===发送消息====11111=====");

    }
}
