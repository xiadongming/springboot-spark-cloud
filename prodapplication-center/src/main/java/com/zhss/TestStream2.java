package com.zhss;

import com.zhss.entity.UserInfo;

import java.util.ArrayList;

/**
 * @Date: 2021/7/2 15:55
 * @Desc:
 */
public class TestStream2 {

    public static void main(String[] args) {

        ArrayList<UserInfo> stringList = new ArrayList<UserInfo>();

        for (int i = 0; i < 55019; i++) {
            UserInfo UserInfo = new UserInfo();
            stringList.add(UserInfo);
        }

        long time1 = System.currentTimeMillis();
        for (UserInfo string : stringList) {
            //System.out.println("增强for = " + string);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("增强for = " + (time2 - time1));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        long time3 = System.currentTimeMillis();
        stringList.stream().forEach(de -> {//有序的
            //System.out.println("stream = " + de);
        });
        long time4 = System.currentTimeMillis();
        System.out.println("stream() = " + (time4 - time3));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");



    }

}
