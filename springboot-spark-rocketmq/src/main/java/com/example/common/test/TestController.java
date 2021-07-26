package com.example.common.test;

import com.example.common.RocketMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/5/21 18:19
 * @Desc:
 */
@RestController
public class TestController {

    @Autowired
    private RocketMQProducer rocketMQProducer;

    @RequestMapping(value = "/rocket", method = RequestMethod.GET)
    public Object sendMsg() {
        rocketMQProducer.send();
        return "successful";
    }
}
