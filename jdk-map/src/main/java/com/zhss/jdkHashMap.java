package com.zhss;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2021/6/25 14:56
 * @Desc:
 */
public class jdkHashMap {

    public static void main(String[] args) {

        Map<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.putIfAbsent("a","b");
        System.out.println(stringStringHashMap);

    }
}
