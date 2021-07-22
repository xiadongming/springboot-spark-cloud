package com.zhss;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2021/7/8 10:00
 * @Desc:
 */
public class TestDemo2 {
    /**
     * 左移n位相当于乘以2的n次方
     *  如：3 << 3  等价于  3 * 2 ^3
     * 右移n位相当于除以2的n次方
     *  如 8 >> 3   等价于 8 / (2^3)
     */
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();

        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");

        String first = strings.get(0);//1
        System.out.println(strings.get(0));
        strings.remove(first);

        System.out.println(strings.get(0));//2

        ExecutorService executorService = Executors.newFixedThreadPool(23);
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        System.out.println(-1 << 29);
        System.out.println(1 << 29);
        System.out.println(2 << 29);

    }

}
