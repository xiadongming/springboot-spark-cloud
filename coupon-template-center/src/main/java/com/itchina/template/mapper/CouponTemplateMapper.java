package com.itchina.template.mapper;

import com.itchina.template.entity.CouponTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date: 2021/4/8 22:37
 * @Desc:
 */
@Mapper
public interface CouponTemplateMapper {
    List<CouponTemplate> selectAll();
}
