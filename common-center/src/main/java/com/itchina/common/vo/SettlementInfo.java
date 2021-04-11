package com.itchina.common.vo;

import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2021/4/10 10:30
 * @Desc:  优惠卷列表结算
 */
public class SettlementInfo {


    Long userId;
    /** 商品信息 */
    List<GoodsInfo> goodsInfos;
    /** 优惠卷列表 */
    List<CouponTemplateSDK> couponTemplateSDKList;
    /** 结果结算金额 */
    Double cost;
    /** 是否使结算生效，即核销 true-核销，false-结算 */
    Boolean employ;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<GoodsInfo> getGoodsInfos() {
        return goodsInfos;
    }

    public void setGoodsInfos(List<GoodsInfo> goodsInfos) {
        this.goodsInfos = goodsInfos;
    }

    public List<CouponTemplateSDK> getCouponTemplateSDKList() {
        return couponTemplateSDKList;
    }

    public void setCouponTemplateSDKList(List<CouponTemplateSDK> couponTemplateSDKList) {
        this.couponTemplateSDKList = couponTemplateSDKList;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Boolean getEmploy() {
        return employ;
    }

    public void setEmploy(Boolean employ) {
        this.employ = employ;
    }

    @Override
    public String toString() {
        return "SettlementInfo{" +
                "userId=" + userId +
                ", goodsInfos=" + goodsInfos +
                ", couponTemplateSDKList=" + couponTemplateSDKList +
                ", cost=" + cost +
                ", employ=" + employ +
                '}';
    }
}
