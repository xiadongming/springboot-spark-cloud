package com.zhss.threadlocal.entity;

import java.io.Serializable;
import java.util.function.UnaryOperator;

/**
 * @Date: 2021/7/6 18:26
 * @Desc:
 */
public class UserInfo extends UserInfoBaseBO implements  Serializable {


    private String name;

    private String loginName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                '}';
    }
}
