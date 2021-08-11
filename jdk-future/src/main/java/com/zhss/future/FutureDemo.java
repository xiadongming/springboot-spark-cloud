package com.zhss.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Date: 2021/8/11 10:05
 * @Desc:
 */
public class FutureDemo {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<String> strList = getList();


        List<Future<String>> futureList = new ArrayList<>();
        Future<String> future = null;

        long startTime = System.currentTimeMillis();

        for (String str : strList) {
            future = executorService.submit(new BatchParseOrgCallableService(str));
            futureList.add(future);
        }

        for (Future<String> stringFuture : futureList) {
            stringFuture.get();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Future+deltaTime= " + (endTime - startTime));

        //================================
        CompletableFuture<Void> all = null;
        for (String str : strList) {
            // 定义任务
            CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
                return str;
            }, executorService);

            all = CompletableFuture.allOf(cf);
        }
        // 开始等待所有任务执行完成
        all.join();

        long endTime2 = System.currentTimeMillis();

        System.out.println("CompletableFuture+deltaTime= " + (endTime2 - startTime));



    }

    private static List<String> getList() {

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            strings.add("abc" + i);
        }
        return strings;
    }

}
