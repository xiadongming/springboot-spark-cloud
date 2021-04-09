package com.itchina.template.service.impl;

import com.itchina.common.vo.TemplateRequest;
import com.itchina.template.entity.CouponTemplate;
import com.itchina.template.mapper.CouponTemplateMapper;
import com.itchina.template.service.IAsyncService;
import com.itchina.template.service.IBulidTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Date: 2021/4/9 21:51
 * @Desc:
 */
@Service
public class BulidTemplateServiceImpl implements IBulidTemplateService {
    /**
     * 异步创建优惠卷码
     * */
    @Autowired
    private IAsyncService asyncService;
    @Autowired
    CouponTemplateMapper couponTemplateMapper;

    @Override
    public CouponTemplate buildTemplate(TemplateRequest templateRequest) {

        CouponTemplate couponTemplate = createCouponTemplate(templateRequest);
        try{
            /**
             * 保存优惠卷模板
             * */
            couponTemplateMapper.saveTemplate(couponTemplate);
            if(null != couponTemplate){
                /**
                 * 保存优惠卷码
                 * */
                asyncService.asyncContructCouponByTemplate(couponTemplate);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return couponTemplate;
    }

    private CouponTemplate createCouponTemplate(TemplateRequest templateRequest) {
        CouponTemplate couponTemplate = new CouponTemplate();

        couponTemplate.setAvailable("0");
        couponTemplate.setCategory(templateRequest.getCategory());
        couponTemplate.setCount(templateRequest.getCount());
        couponTemplate.setCreateTime(new Date());
        couponTemplate.setDesc(templateRequest.getDesc());
        couponTemplate.setExpired("0");
        //couponTemplate.setKey();
        couponTemplate.setLogo(templateRequest.getLogo());
        couponTemplate.setName(templateRequest.getName());
        couponTemplate.setProductLine(String.valueOf(templateRequest.getProductLine()));
        couponTemplate.setRule(String.valueOf(templateRequest.getRule()));
        couponTemplate.setTarget(templateRequest.getTarget());
        couponTemplate.setUserId(templateRequest.getUserId());
        return couponTemplate;
    }
}
