package com.zhss.threadlocal.utils;

import com.zhss.threadlocal.entity.UserInfo;

import java.util.Currency;

/**
 * @Date: 2021/7/6 18:23
 * @Desc: threadLocal全局用户信息
 */
public class GloalThreadLocalUserinfo {

    private static ThreadLocal<UserInfo> current_user = new ThreadLocal<>();

    private GloalThreadLocalUserinfo() {
    }
    public static void setCurrentUser(UserInfo userInfo) {
        current_user.set(userInfo);
    }
    public static UserInfo getCurrentUser() {
        return current_user.get();
    }
    public static void removeUserinfo(){
        current_user.remove();
    }

    public static  ThreadLocal<UserInfo>  getThreadLocal(){
        return current_user;
    }

}
