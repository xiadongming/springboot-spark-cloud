package com.zhss.two;

import com.zhss.Event;

/**
 * @Date: 2021/8/13 14:20
 * @Desc:
 */
public class CallBackDemo2 {

    public static void main(String[] args) {

        sayHello(new EventImpl());

    }
    /**
     * 调用回调函数
     * @param event
     */
    private static void sayHello(Event event) {
        System.out.println("执行sayHello函数");
        //调用
        System.out.println("执行回调函数event " + event.callBackResponse());
    }
}
