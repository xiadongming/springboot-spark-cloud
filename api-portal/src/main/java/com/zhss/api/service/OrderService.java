package com.zhss.api.service;

import com.zhss.api.entry.OrderInfoPO;
import com.zhss.api.entry.OrderInfoRspBO;

/**
 * @Date: 2021/7/21 17:04
 * @Desc:
 */
public interface OrderService {

    OrderInfoRspBO queryOrders(OrderInfoPO orderInfoPO);

}
