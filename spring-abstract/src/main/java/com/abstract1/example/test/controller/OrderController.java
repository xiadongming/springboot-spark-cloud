package com.abstract1.example.test.controller;

import com.abstract1.example.test.factory.OrderFactory;
import com.abstract1.example.test.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/6/4 21:00
 * @Desc:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderFactory orderFactory;


    @RequestMapping(value = "/dev")
    public Object getTest(String id) {
        OrderService factory = orderFactory.createFactory(id);
        return factory.doCreateOrder();
    }
}
