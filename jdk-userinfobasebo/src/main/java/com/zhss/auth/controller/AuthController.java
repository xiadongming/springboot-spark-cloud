package com.zhss.auth.controller;

import com.zhss.auth.entity.UserInfoBaseBOExten;
import com.zhss.auth.entity.UserInfoBaseBOExten2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/7/28 18:50
 * @Desc:
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @RequestMapping(value = "/")
    public void getTest() {

        UserInfoBaseBOExten userExten = new UserInfoBaseBOExten();
        userExten.setmLoginName("xdm_login_name");
        userExten.setmUserName("大北京");
        System.out.println("auth= " + userExten.getmLoginName());
        System.out.println("auth= " + userExten.getmUserName());
    }

    @RequestMapping(value = "/auth2")
    public void getTest2() {
        UserInfoBaseBOExten2 userInfoBaseBOExten2 = new UserInfoBaseBOExten2();
        System.out.println("auth2= " + userInfoBaseBOExten2.getmLoginName());
        System.out.println("auth2= " + userInfoBaseBOExten2.getmUserName());

    }

    @RequestMapping(value = "/auth3")
    public void getTest3(UserInfoBaseBOExten2 userInfoBaseBOExten2) {

        System.out.println("auth3= " + userInfoBaseBOExten2.getmLoginName());
        System.out.println("auth3= " + userInfoBaseBOExten2.getmUserName());

    }

}
