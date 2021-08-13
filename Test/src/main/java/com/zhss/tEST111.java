package com.zhss;

/**
 * @Date: 2021/8/11 11:43
 * @Desc:
 */
public class tEST111 {

    public static void main(String[] args) {


        Long a = 1L;
        Long b = 0L;

        String key = "9200121690";
        int h;
        Integer abc = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        System.out.println(String.valueOf(abc).substring(1));
        System.out.println(String.valueOf(abc));
    }

}
