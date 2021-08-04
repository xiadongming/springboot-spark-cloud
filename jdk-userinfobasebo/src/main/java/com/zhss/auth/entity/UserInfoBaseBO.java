package com.zhss.auth.entity;

import java.io.Serializable;

/**
 * @Date: 2021/7/28 18:51
 * @Desc:
 */
public class UserInfoBaseBO implements Serializable {



    private String mLoginName;

    private String mUserName;


    public String getmLoginName() {
        return mLoginName;
    }

    public void setmLoginName(String mLoginName) {
        this.mLoginName = mLoginName;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    @Override
    public String toString() {
        return "UserInfoBaseBO{" +
                "mLoginName='" + mLoginName + '\'' +
                ", mUserName='" + mUserName + '\'' +
                '}';
    }
}
