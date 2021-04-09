package com.itchina.template.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @Date: 2021/4/9 7:47
 * @Desc:
 */
public class MyExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        System.out.println("异步error= " + ex.getMessage());
        System.out.println("异步method= " + method.getName());
        System.out.println("异步params= " + JSON.toJSONString(params));
        ex.printStackTrace();
    }
}
