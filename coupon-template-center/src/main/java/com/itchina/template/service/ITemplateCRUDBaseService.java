package com.itchina.template.service;

import com.itchina.common.vo.CouponTemplateSDK;
import com.itchina.template.entity.CouponTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/4/9 8:07
 * @Desc: 基础服务 增删改查
 */
public interface ITemplateCRUDBaseService {
    /**
     * 根据优惠卷id获取优惠卷模板信息
     * */
    CouponTemplate buildTemplate(Integer id);
    /**
     * 查询所有可用的优惠卷模板
     * */
    List<CouponTemplateSDK> selectAllUsableTemplate();
    /**
     * 获取模板ids到CouponTemplateSDK的映射关系
     * key 优惠卷模板id
     * */
    Map<Integer,CouponTemplateSDK> findIds2TemplateSDK(Collection<Integer>ids);

}
