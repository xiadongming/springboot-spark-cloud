package com.itchina.template.service.impl;

import com.itchina.template.entity.CouponTemplate;
import com.itchina.template.mapper.CouponTemplateMapper;
import com.itchina.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date: 2021/4/8 22:42
 * @Desc:
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    CouponTemplateMapper couponTemplateMapper ;
    @Override
    public List<CouponTemplate> selectAllTemplate() {
        List<CouponTemplate> couponTemplateList =  couponTemplateMapper.selectAll();
        return couponTemplateList;
    }
}
