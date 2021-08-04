package com.example.demo.kafka1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/kafka")
    public String producer() {
        kafkaTemplate.send("test-topic-xmd-2108004", "hello-world");
        System.out.println("发送成功");
        return "successful";
    }
}
