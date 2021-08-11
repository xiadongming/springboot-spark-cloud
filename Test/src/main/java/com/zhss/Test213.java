package com.zhss;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date: 2021/8/10 15:33
 * @Desc:
 */
public class Test213 {

    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        Date date = new Date();

        System.out.println(simpleDateFormat.format(date));

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");

        System.out.println(simpleDateFormat2.format(date));


    }

}
