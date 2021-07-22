package com.zhss.api.service.impl;

import com.zhss.api.entry.OrderInfoPO;
import com.zhss.api.entry.OrderInfoRspBO;
import com.zhss.api.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Date: 2021/7/21 17:05
 * @Desc:
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public OrderInfoRspBO queryOrders(OrderInfoPO orderInfoPO) {
        logger.info("调用订单查询入参orderInfoPO= {}",orderInfoPO);
        OrderInfoRspBO rspBO = orderInfoPO.clone(OrderInfoRspBO.class);
        return rspBO;
    }




}
