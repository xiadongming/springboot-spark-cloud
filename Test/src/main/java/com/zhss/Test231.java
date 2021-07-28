package com.zhss;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Date: 2021/7/28 10:24
 * @Desc:
 */
public class Test231 {

    public static void main(String[] args) {

        Map<String, String> stringStringHashMap = new LinkedHashMap<>(3);

        stringStringHashMap.put("oldPassword","Cmdc!2030");
        stringStringHashMap.put("confirmPwd","Cmdc!2030112");
        stringStringHashMap.put("newPassword","Cmdc!2030112");

        System.out.println(JSONObject.toJSONString(stringStringHashMap));

    }
}
