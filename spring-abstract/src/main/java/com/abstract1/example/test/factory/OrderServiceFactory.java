package com.abstract1.example.test.factory;

import com.abstract1.example.test.OrderQueryServiceImpl;
import com.abstract1.example.test.OrderService;
import com.abstract1.example.test.OrderUpdateServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date: 2021/6/4 21:05
 * @Desc:
 */
@Service
public class OrderServiceFactory implements OrderFactory {


    @Resource(name = "orderUpdateService")
    private OrderService orderService;

    @Resource(name = "orderQueryService")
    private OrderQueryServiceImpl orderQueryService;

    @Resource(name = "orderUpdateService")
    private OrderUpdateServiceImpl orderUpdateService;

    @Override
    public OrderService createFactory(String id) {
        switch (id) {
            case "1":
                return orderQueryService;
            case "2":
                return orderUpdateService;
        }
        return null;
    }
}
