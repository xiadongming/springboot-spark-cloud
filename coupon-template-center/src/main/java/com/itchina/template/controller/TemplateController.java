package com.itchina.template.controller;

import com.alibaba.fastjson.JSON;
import com.itchina.common.exception.CouponException;
import com.itchina.common.vo.CouponTemplateSDK;
import com.itchina.common.vo.TemplateRequest;
import com.itchina.template.entity.CouponTemplate;
import com.itchina.template.service.IBuildTemplateService;
import com.itchina.template.service.ITemplateBaseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/4/10 7:50
 * @Desc:
 */
@RestController
public class TemplateController {
    @Autowired
    IBuildTemplateService bulidTemplateService;
    @Autowired
    ITemplateBaseService templateCRUDBaseService;
    /**
     * 构建优惠卷模板
     * 请求路径 localhost:10000/coupan-template/template/build
     * 网关请求 localhost:9000/my/coupan-template/template/build
     */
    @RequestMapping(value = "/template/build", method = {RequestMethod.GET, RequestMethod.POST})
    public CouponTemplate buildTemplate(@RequestBody TemplateRequest request) throws CouponException {
        System.out.println("构建优惠卷模板 入参= " + JSON.toJSONString(request));

        CouponTemplate couponTemplate = bulidTemplateService.buildTemplate(request);

        return couponTemplate;
    }
    /**
     * 查询优惠卷模板
     * localhost:10000/coupan-template/template/info
     * 网关请求 localhost:9000/my/coupan-template/template/info
     * */
    @RequestMapping(value = "/template/info", method = {RequestMethod.GET, RequestMethod.POST})
    public CouponTemplate buildTemplateInfo(@Param("id") Integer id) throws CouponException {
        System.out.println("查询优惠卷模板 入参= " + id);
        CouponTemplate couponTemplate1 = templateCRUDBaseService.buildTemplateInfo(id);

        System.out.println("结果：couponTemplate1= " + couponTemplate1);

        return couponTemplate1;
    }
    /**
     * 获取所有优惠卷模板
     * localhost:10000/coupan-template/template/info
     * 网关请求 localhost:9000/my/coupan-template/template/info
     * */
    @RequestMapping(value = "/template/sdk/all", method = {RequestMethod.GET, RequestMethod.POST})
    public List<CouponTemplateSDK>  finaAllUsableTemplcate() {
        System.out.println("查询所有可用优惠卷模板 入参= ");
        int a = 100 / 0;
        List<CouponTemplateSDK> couponTemplateSDKS = templateCRUDBaseService.findAllUsableTemplate();
        return couponTemplateSDKS;
    }
    /**
     * 获取优惠卷模板信息
     * localhost:10000/coupan-template/template/sdk/infos
     * 网关请求 localhost:9000/my/coupan-template/template/sdk/infos
     * */
    @RequestMapping(value = "/template/sdk/infos", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<Integer, CouponTemplateSDK>  findIds2TemplateSDK(@Param("ids") Collection<Integer> ids) {
        System.out.println("查询所有可用优惠卷模板 入参= ");
        Map<Integer, CouponTemplateSDK> ids2TemplateSDK = templateCRUDBaseService.findIds2TemplateSDK(ids);
        return ids2TemplateSDK;
    }
}
