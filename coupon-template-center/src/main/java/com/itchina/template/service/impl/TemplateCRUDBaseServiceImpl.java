package com.itchina.template.service.impl;

import com.itchina.common.vo.CouponTemplateSDK;
import com.itchina.template.entity.CouponTemplate;
import com.itchina.template.mapper.CouponTemplateMapper;
import com.itchina.template.service.ITemplateCRUDBaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/4/9 22:05
 * @Desc:
 */
@Service
public class TemplateCRUDBaseServiceImpl implements ITemplateCRUDBaseService {
    @Autowired
    CouponTemplateMapper couponTemplateMapper;

    @Override
    public CouponTemplate buildTemplate(Integer id) {
        CouponTemplate couponTemplate = couponTemplateMapper.selectTemplateById(id);
        return couponTemplate;
    }

    @Override
    public List<CouponTemplateSDK> selectAllUsableTemplate() {
        List<CouponTemplateSDK> couponTemplates = couponTemplateMapper.selectAll();
        return couponTemplates;
    }

    @Override
    public Map<Integer, CouponTemplateSDK> findIds2TemplateSDK(Collection<Integer> ids) {
        /**
         * 方便起见，循环调用
         * */
        CouponTemplateSDK couponTemplateSDK = new CouponTemplateSDK();
        HashMap<Integer, CouponTemplateSDK> integerCouponTemplateSDKHashMap = new HashMap<>();
        for (Integer id : ids) {
            CouponTemplate couponTemplate = couponTemplateMapper.selectTemplateById(id);
            BeanUtils.copyProperties(couponTemplate,couponTemplateSDK);
            integerCouponTemplateSDKHashMap.put(couponTemplate.getId(),couponTemplateSDK);
        }
        return integerCouponTemplateSDKHashMap;
    }
}
