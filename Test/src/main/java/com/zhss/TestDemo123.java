package com.zhss;

/**
 * @Date: 2021/7/19 16:00
 * @Desc:
 */
public class TestDemo123 {
    public static void main(String[] args) {

        String replace = "9200007227-920000923";
        //String newReplace = replace.replace(orgIdIndex1 + "-", "");

        String orgIdIndex1 = replace.substring(0, replace.indexOf("-"));

        System.out.println("orgIdIndex1= " + orgIdIndex1);

        String newReplace = replace.replace(orgIdIndex1 + "-", "");

        System.out.println("newReplace= " + newReplace);



        String abcd = "9200011420-";

        String orgIdIndex12 = abcd.substring(0, replace.indexOf("-"));

        System.out.println(orgIdIndex12);

        System.out.println(abcd.replace(orgIdIndex12 + "-", ""));

    }

}
