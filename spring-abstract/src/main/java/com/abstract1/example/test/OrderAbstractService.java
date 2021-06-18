package com.abstract1.example.test;

import org.springframework.stereotype.Service;

/**
 * @Date: 2021/6/4 20:53
 * @Desc:
 */
//@Service("orderAbstractService")
public abstract class OrderAbstractService implements OrderService {
    public void voladition() {
        System.out.println("父类通用方法");
    }
}
