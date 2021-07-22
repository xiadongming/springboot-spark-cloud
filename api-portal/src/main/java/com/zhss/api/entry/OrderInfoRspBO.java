package com.zhss.api.entry;

import java.io.Serializable;

/**
 * @Date: 2021/7/21 17:06
 * @Desc:
 */
public class OrderInfoRspBO implements Serializable {

    private String orderId;

    private String orderName;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "OrderInfoPO{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
