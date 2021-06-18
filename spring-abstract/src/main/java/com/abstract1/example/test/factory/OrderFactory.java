package com.abstract1.example.test.factory;

import com.abstract1.example.test.OrderService;

/**
 * @Date: 2021/6/4 21:04
 * @Desc:
 */
public interface OrderFactory {

    OrderService createFactory(String id);

}
