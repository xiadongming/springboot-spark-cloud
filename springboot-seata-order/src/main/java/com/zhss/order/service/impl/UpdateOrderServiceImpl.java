package com.zhss.order.service.impl;

import com.zhss.order.entity.Order;
import com.zhss.order.mapper.OrderMapper;
import com.zhss.order.service.UpdateOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Date: 2021/7/27 15:31
 * @Desc:
 */
@Service
public class UpdateOrderServiceImpl implements UpdateOrderService {

    private static final Logger logger = LoggerFactory.getLogger(UpdateOrderServiceImpl.class);


    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void createOrder() throws Exception {
        try {
            Order order = new Order();
            order.setAmount(100);
            order.setUserId("100");
            order.setCommodityCode(String.valueOf(new Random().nextInt(1000)));
            order.setCount(300);
            order.setOrderNo(String.valueOf(new Random().nextInt(100)));
            orderMapper.saveTemplate(order);
        } catch (Exception e) {
            logger.error("更新订单失败", e);
            throw new Exception();
        }
    }
}
