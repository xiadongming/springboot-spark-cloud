package com.itchina.distribution.vo;


import java.util.List;

/**
 * <h1>优惠券 kafka 消息对象定义</h1>
 */
public class CouponKafkaMessage {

    /** 优惠券状态 */
    private Integer status;

    /** Coupon 主键 */
    private List<Integer> ids;

    public CouponKafkaMessage(Integer code, List<Integer> collect) {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "CouponKafkaMessage{" +
                "status=" + status +
                ", ids=" + ids +
                '}';
    }
}
