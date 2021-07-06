package com.zhss;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Date: 2021/6/26 10:33
 * @Desc:
 */
public class RegexApplication {

    public static void main(String[] args) {



        String text = "Hello ,//,]][[Regex!";

        Pattern p=Pattern.compile("[.,\"\\?!:']");//增加对应的标点

        Matcher m=p.matcher(text);

        String first=m.replaceAll(""); //把英文标点符号替换成空，即去掉英文标点符号

        System.out.println(first);


        Object object = new Object();

        synchronized (object){

        }


    }
}
