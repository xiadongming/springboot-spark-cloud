package com.itchina.controller;

import com.itchina.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by hzllb on 2018/11/18.
 */
@Controller("order")
@RequestMapping("/order")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/abc")
    public void getTest() {
        Integer userId = 100;
        Integer itemId = 200;
        Integer promoId = 300;
        Integer amount = 400;
        String  stockLogId = "500";

        orderService.createOrder(userId,itemId,promoId,amount,stockLogId);
    }

}
