package com.zhss;

import java.util.regex.Pattern;

/**
 * @Date: 2021/7/22 10:15
 * @Desc:
 */
public class Test234 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[0-9]*");


        String str = "840272463886557184";

        System.out.println(pattern.matcher(str).matches());


        System.out.println(str.matches("^[0-9]*$"));
    }
}
