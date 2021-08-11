package com.zhss.snow;

/**
 * @Date: 2021/8/5 17:55
 * @Desc:
 */
public class SnowTest {

    public static void main(String[] args) {

        long snow = IdGeneratorSnowFlakeUtils.snowflakeId();
        System.out.println(snow);
        System.out.println(String.valueOf(snow).length());

        String str = "816455262952443904";
        System.out.println(str.length());





    }

}
