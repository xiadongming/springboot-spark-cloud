package com.itchina.seckill.controller;

import com.itchina.seckill.entity.SeckillUserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/4/13 7:53
 * @Desc:
 */
@RestController
public class GoodsController {

    @RequestMapping(value = "/list",method = {RequestMethod.POST,RequestMethod.GET})
    public Object getGoodsList(SeckillUserInfo seckillUserInfo){

        System.out.println("赋值seckillUserInfo= " + seckillUserInfo);

        return seckillUserInfo;
    }

    @RequestMapping(value = "/detail",method = {RequestMethod.POST,RequestMethod.GET})
    public Object getGoodsDetail(SeckillUserInfo seckillUserInfo){

        System.out.println("赋值seckillUserInfo= " + seckillUserInfo);

        return seckillUserInfo;
    }

}
