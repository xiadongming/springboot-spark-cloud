package com.zhss;

import com.zhss.entity.UserInfo;

import java.util.ArrayList;

/**
 * @Date: 2021/7/2 15:55
 * @Desc:
 */
public class TestStream {

    public static void main(String[] args) {

        ArrayList<UserInfo> stringList = new ArrayList<UserInfo>();

        for (int i = 0; i < 390; i++) {
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


        long time12 = System.currentTimeMillis();
        stringList.forEach(ele ->{

        });
        long time123 = System.currentTimeMillis();
        System.out.println("forEach = " + (time123 - time12));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");


        long time3 = System.currentTimeMillis();
        stringList.stream().forEach(de -> {//有序的
            //System.out.println("stream = " + de);
        });
        long time4 = System.currentTimeMillis();
        System.out.println("stream() = " + (time4 - time3));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        long time5 = System.currentTimeMillis();
        stringList.parallelStream().forEach(de -> { //无须的
            //System.out.println("parallelStream= " + de);
        });
        long time6 = System.currentTimeMillis();
        System.out.println("parallelStream() = " + (time6 - time5));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        long time7 = System.currentTimeMillis();
        stringList.stream().parallel().forEach(de -> {//无须的
            //System.out.println("stream().parallel= " + de);
        });
        long time8 = System.currentTimeMillis();
        System.out.println("stream().parallel() = " + (time8 - time7));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }

}
