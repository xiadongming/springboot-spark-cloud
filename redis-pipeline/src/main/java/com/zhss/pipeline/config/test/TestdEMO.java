package com.zhss.pipeline.config.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Date: 2021/6/18 19:57
 * @Desc:
 */
public class TestdEMO {

    public static void main(String[] args) {

        Set<String> objects = new HashSet<>();

        Set<String> strings = Collections.synchronizedSet(objects);

        strings.add("石家庄-深泽县煊硕赵八乡特许厅011");
        strings.add("石家庄-深泽县妍妍西苑街特许厅022");

        String str = "石家庄-深泽县妍妍西苑街特许厅022";
        System.out.println(strings);
        System.out.println(strings.contains(str));



    }
}
