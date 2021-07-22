package com.zhss.threadlocal.entity;

/**
 * @Date: 2021/7/7 11:34
 * @Desc:
 */
public class UserInfoBaseBO {

    public String mName;
    public String mLoginName;


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmLoginName() {
        return mLoginName;
    }

    public void setmLoginName(String mLoginName) {
        this.mLoginName = mLoginName;
    }

    @Override
    public String toString() {
        return "UserInfoBaseBO{" +
                "mName='" + mName + '\'' +
                ", mLoginName='" + mLoginName + '\'' +
                '}';
    }
}
