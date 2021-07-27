package com.zhss;

import com.alibaba.fastjson.JSONObject;

/**
 * @Date: 2021/7/27 11:11
 * @Desc:
 */
public class Test223 {

    public static void main(String[] args) {


        String str = "{\"oldPassword\":\"123456\",\"confirmPwd\":\"ABCabc123\",\"newPassword\":\"ABCabc123\"}";


        JSONObject jsonObject = JSONObject.parseObject(str);
        Object o = jsonObject.get("newPassword");
        System.out.println(o);

    }
}
