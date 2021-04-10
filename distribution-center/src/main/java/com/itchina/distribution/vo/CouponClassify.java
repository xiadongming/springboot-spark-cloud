package com.itchina.distribution.vo;

import com.itchina.common.constant.PeriodType;
import com.itchina.distribution.constant.CouponStatus;
import com.itchina.distribution.entity.Coupon;
import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <h1>用户优惠券的分类, 根据优惠券状态</h1>
 */
public class CouponClassify {

    /** 可以使用的 */
    private List<Coupon> usable;

    /** 已使用的 */
    private List<Coupon> used;

    /** 已过期的 */
    private List<Coupon> expired;

    /**
     * <h2>对当前的优惠券进行分类</h2>
     * */
    public static CouponClassify classify(List<Coupon> coupons) {

        List<Coupon> usable = new ArrayList<>(coupons.size());
        List<Coupon> used = new ArrayList<>(coupons.size());
        List<Coupon> expired = new ArrayList<>(coupons.size());

        coupons.forEach(c -> {

            // 判断优惠券是否过期
            boolean isTimeExpire;
            long curTime = new Date().getTime();

            if (c.getTemplateSDK().getRule().getExpiration().getPeriod().equals(
                    PeriodType.REGULAR.getCode()
            )) {
                isTimeExpire = c.getTemplateSDK().getRule().getExpiration()
                        .getDeadline() <= curTime;
            } else {
                isTimeExpire = DateUtils.addDays(
                        c.getAssignTime(),
                        c.getTemplateSDK().getRule().getExpiration().getGap()
                ).getTime() <= curTime;
            }

           /* if (c.getStatus() == CouponStatus.USED) {
                used.add(c);
            } else if (c.getStatus() == CouponStatus.EXPIRED || isTimeExpire) {
                expired.add(c);
            } else {
                usable.add(c);
            }*/
        });

        return new CouponClassify(usable, used, expired);
    }

    public CouponClassify(List<Coupon> usable, List<Coupon> used, List<Coupon> expired) {
        this.usable = usable;
        this.used = used;
        this.expired = expired;
    }

    public List<Coupon> getUsable() {
        return usable;
    }

    public void setUsable(List<Coupon> usable) {
        this.usable = usable;
    }

    public List<Coupon> getUsed() {
        return used;
    }

    public void setUsed(List<Coupon> used) {
        this.used = used;
    }

    public List<Coupon> getExpired() {
        return expired;
    }

    public void setExpired(List<Coupon> expired) {
        this.expired = expired;
    }
}
