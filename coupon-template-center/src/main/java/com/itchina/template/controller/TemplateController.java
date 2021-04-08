package com.itchina.template.controller;

import com.itchina.template.entity.CouponTemplate;
import com.itchina.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date: 2021/4/8 22:40
 * @Desc:
 */
@RestController
@RequestMapping("/dev")
public class TemplateController {

    @Autowired
    TemplateService TemplateService ;

    @RequestMapping(value="/template")
    public Object getTest(){
        List<CouponTemplate> couponTemplates = TemplateService.selectAllTemplate();
        System.out.println("couponTemplates= "+couponTemplates);
        return "successful";
    }

}
