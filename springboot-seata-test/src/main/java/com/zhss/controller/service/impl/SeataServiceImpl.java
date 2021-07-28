package com.zhss.controller.service.impl;

import com.zhss.controller.service.SeataService;
import com.zhss.order.service.UpdateOrderService;
import com.zhss.stock.service.UpdateStockService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date: 2021/7/27 16:00
 * @Desc:
 */
@Service
public class SeataServiceImpl implements SeataService {

    @Autowired
    private UpdateStockService updateStockService;

    @Autowired
    private UpdateOrderService updateOrderService;


    @GlobalTransactional(rollbackFor = Exception.class)
    @Override
    public Object seateCreate() throws Exception {

        try {
            updateStockService.createStock();
            updateOrderService.createOrder();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
        return null;
    }
}
