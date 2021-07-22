package com.zhss.threadlocal;

import com.zhss.threadlocal.entity.UserInfo;
import com.zhss.threadlocal.service.ThreadLocalService;
import com.zhss.threadlocal.utils.GloalThreadLocalUserinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/7/6 17:09
 * @Desc:
 */
@RestController
public class ThreadLocalController {

    @Autowired
    ThreadLocalService threadLocalService;

    /**
     * 实际项目中，应该在security设置用户信息点的时候，设置导threadLocal中，做一个全局变量
     */
    @RequestMapping("/thread")
    public void getTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("xiadongming");
        userInfo.setName("夏东明");
        GloalThreadLocalUserinfo.setCurrentUser(userInfo);
        System.out.println("contro= " + GloalThreadLocalUserinfo.getCurrentUser());
        threadLocalService.test();
        //清空当前线程用户信息
        GloalThreadLocalUserinfo.removeUserinfo();
        System.out.println("contro2= " + GloalThreadLocalUserinfo.getCurrentUser());
    }


}
