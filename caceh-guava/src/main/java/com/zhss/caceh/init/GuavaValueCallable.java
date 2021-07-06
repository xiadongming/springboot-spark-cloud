package com.zhss.caceh.init;

import java.util.concurrent.Callable;

/**
 * @Date: 2021/6/23 11:17
 * @Desc:
 */

public class GuavaValueCallable implements Callable<String> {
    String key;

    public GuavaValueCallable(String key) {
        this.key = key;
    }
    @Override
    public String call() throws Exception {
        return loadValue(key);
    }
    private String loadValue(String key) {
        System.out.println("加载数据");
        return "successful100";
    }
}
