package com.example.trans.test;

import com.example.trans.TransRocketMQProducer;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/5/24 18:01
 * @Desc:
 */
@RestController
public class TestTransController {


    @Autowired
    TransRocketMQProducer  transRocketMQProducer;


    @RequestMapping(value = "/transRocketmq", method = {RequestMethod.GET, RequestMethod.POST})
    public Object rocketMqRequest() {

        transRocketMQProducer.send();

        return "发送成功";
    }

}
