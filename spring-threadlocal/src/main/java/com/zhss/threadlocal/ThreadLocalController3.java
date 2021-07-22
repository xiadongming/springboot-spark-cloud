package com.zhss.threadlocal;

import com.zhss.threadlocal.entity.RequestRecordBO;
import com.zhss.threadlocal.entity.UserInfo;
import com.zhss.threadlocal.utils.GloalThreadLocalUserinfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/7/7 11:24
 * @Desc:
 */
@RestController
public class ThreadLocalController3 {


    @RequestMapping("/login")
    public Object getTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("xiadongming");
        userInfo.setName("夏东明");

        RequestRecordBO requestRecordBO = new RequestRecordBO();

        requestRecordBO.setUserInfoBaseBO(userInfo);

        System.out.println("userInfo= " + userInfo);
        System.out.println(userInfo.mLoginName + ", " + userInfo.getmName());


        System.out.println("requestRecordBO= " + requestRecordBO);
        return requestRecordBO;
    }
}
