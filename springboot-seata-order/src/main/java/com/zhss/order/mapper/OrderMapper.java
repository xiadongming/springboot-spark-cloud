package com.zhss.order.mapper;

import com.zhss.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date: 2021/4/8 22:37
 * @Desc:
 */
@Mapper
public interface OrderMapper {

    List<Order> selectAll();

    void saveTemplate(Order order);

}
