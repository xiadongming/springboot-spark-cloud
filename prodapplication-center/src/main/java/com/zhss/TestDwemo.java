package com.zhss;

/**
 * @Date: 2021/7/2 10:59
 * @Desc:
 */
public class TestDwemo {

    public static void main(String[] args) {

        String str  = "朔州市朔城区火车站    一区60号\n" +
                "\n" +
                "山西省运城市盐湖区解放北路789号";

        System.out.println(str);


        System.out.println(str.replaceAll("\r\n|\r|\n", ""));//取出所有換行 和回车);
        System.out.println(str.replaceAll("\\s*|\t|\r|\n", ""));//取出所有換行 和回车,空格);


    }



}
