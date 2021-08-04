package com.zhss.auth.entity;

/**
 * @Date: 2021/7/28 18:52
 * @Desc:
 */
public class UserInfoBaseBOExten extends UserInfoBaseBO{

    private String loginName;
    private String name;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfoBaseBOExten{" +
                "loginName='" + loginName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
