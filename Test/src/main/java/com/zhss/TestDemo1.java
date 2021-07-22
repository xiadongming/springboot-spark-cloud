package com.zhss;

import java.util.*;

/**
 * @Date: 2021/7/16 18:41
 * @Desc:
 */
public class TestDemo1 {

    public static void main(String[] args) {

        String root = "1-2-9100000216-";

        String trr1 = "1-2-9100000216-";
        String trr2 = "1-2-9100000216-9200086289-9200095874-";
        String trr3 = "1-2-9100000216-9200086289-9200095878-";

        List<String> strings = new ArrayList<>();
        strings.add(trr1);
        strings.add(trr2);
        strings.add(trr3);
        //解析成单个的orgId，HashMap<String,List<String>>的结构

        Map<String,List<String>> resultMap = new HashMap<>();
        List<String> childrenOrgIds = new ArrayList<>();


        resultMap.put(root,childrenOrgIds);


        String newString = trr2.replace(root, "");
        System.out.println(newString);//9200086289-9200095874-

        String[] split = newString.split("-");
        System.out.println(Arrays.asList(split));

        for (String string : strings) {

        }
    }

}
