package com.abstract1.example.test;

import org.springframework.stereotype.Service;

/**
 * @Date: 2021/6/4 20:54
 * @Desc:
 */
@Service("orderUpdateService")
public class OrderUpdateServiceImpl extends OrderAbstractService {
    @Override
    public String doCreateOrder() {
        super.voladition();
        return "update-successful";
    }
}
