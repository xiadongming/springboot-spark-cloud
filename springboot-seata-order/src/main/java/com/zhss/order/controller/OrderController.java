package com.zhss.order.controller;

import com.zhss.order.service.UpdateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/7/27 15:50
 * @Desc:
 */
@RestController
public class OrderController {

    @Autowired
    private UpdateOrderService updateOrderService;

    @RequestMapping(value = "/order")
    public void createOrder(){

        try {
            updateOrderService.createOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
