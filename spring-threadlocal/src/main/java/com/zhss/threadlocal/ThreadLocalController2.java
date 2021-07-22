package com.zhss.threadlocal;

import com.zhss.threadlocal.entity.UserInfo;
import com.zhss.threadlocal.utils.GloalThreadLocalUserinfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/7/7 11:24
 * @Desc:
 */
@RestController
public class ThreadLocalController2 {


    @RequestMapping("/thread2")
    public void getTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("xiadongming");
        userInfo.setName("夏东明");

        GloalThreadLocalUserinfo.setCurrentUser(userInfo);
        System.out.println("contro= " + GloalThreadLocalUserinfo.getCurrentUser());




    }
}
