package com.zhss.threadlocal.entity;

/**
 * @Date: 2021/7/7 11:34
 * @Desc:
 */
public class RequestRecordBO {


    private UserInfoBaseBO userInfoBaseBO;

    public UserInfoBaseBO getUserInfoBaseBO() {
        return userInfoBaseBO;
    }

    public void setUserInfoBaseBO(UserInfoBaseBO userInfoBaseBO) {
        this.userInfoBaseBO = userInfoBaseBO;
    }

    @Override
    public String toString() {
        return "RequestRecordBO{" +
                "userInfoBaseBO=" + userInfoBaseBO +
                '}';
    }
}
