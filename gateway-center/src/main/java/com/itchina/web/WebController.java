package com.itchina.web;

import com.itchina.common.vo.CommonResopnse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/4/7 22:54
 * @Desc:
 */
@RestController
@RequestMapping("/web")
public class WebController {
    @RequestMapping(value = "dev",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getTest(){
        //   int a = 100 /0 ;
        return new CommonResopnse<Object>(00,"ok");
    }
}
