package entity;

import utils.BeanCoperUtils;

import java.io.Serializable;

/**
 * @Date: 2021/7/23 15:36
 * @Desc:
 */
public class SearchOrderInfoPO implements Serializable {

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

    public <T> T clone(Class<T> clazz) {
        T tatget = null;
        try {
            tatget = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanCoperUtils.copyProperties(this, tatget);
        return tatget;
    }
    @Override
    public String toString() {
        return "SearchOrderInfoPO{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
