package com.zhss;

/**
 * @Date: 2021/8/13 14:11
 * @Desc:
 */
public class CallBackDemo {

    public static void main(String[] args) {

        /**
         * 回调函数，1-先定义一个接口，
         *         2-方法中的参数是该接口
         *
         */
        sayHello(new Event() {
            @Override
            public String callBackResponse() {
                return "你好";
            }
        });
    }

    /**
     * 调用回调函数
     * @param event
     */
    private static void sayHello(Event event) {
        System.out.println("执行sayHello函数");
        System.out.println("执行回调函数event " + event.callBackResponse());
    }
}
