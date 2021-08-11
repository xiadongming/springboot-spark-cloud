package com.zhss.CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

/**
 * @Date: 2021/8/11 10:03
 * @Desc:
 */
public class CompletableFutureDemo {

    /**
     *
     * 推荐使用 Future +  executorService.submit()
     *  比 CompletableFuture 快
     *
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<String> strList = getList();
        CompletableFuture<Void> all = null;
        long startTime = System.currentTimeMillis();


        for (String str : strList) {
            // 定义任务
            CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
                return str;
            }, executorService);
          /*  cf.whenComplete(new BiConsumer<String, Throwable>() {
                @Override
                public void accept(String t, Throwable u) {
                   // System.out.println("hello " + t);
                }
            });*/
            all = CompletableFuture.allOf(cf);
        }
        // 开始等待所有任务执行完成
        all.join();

        long endTime = System.currentTimeMillis();

        System.out.println("CompletableFuture+deltaTime= " + (endTime - startTime));

    }

    private static List<String> getList() {

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            strings.add("abc" + i);
        }
        return strings;
    }
}
