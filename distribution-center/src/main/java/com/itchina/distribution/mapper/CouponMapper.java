package com.itchina.distribution.mapper;


import com.itchina.distribution.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface CouponMapper  {

    /**
     * <h2>根据 userId + 状态寻找优惠券记录</h2>
     * */
    List<Coupon> findAllByUserIdAndStatus(Long userId, Integer status);

    List<Coupon> findAllById(List<Integer> ids);

    Collection<Object> saveAll(List<Coupon> coupons);
}
