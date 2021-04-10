package com.itchina.distribution.controller;

import com.itchina.common.vo.CouponTemplateSDK;
import com.itchina.distribution.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date: 2021/4/10 17:28
 * @Desc:
 *
 */
@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/user",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getTest() throws Exception {
        List<CouponTemplateSDK> availableTemplate = userService.findAvailableTemplate(1L);
        return availableTemplate;
    }
}
