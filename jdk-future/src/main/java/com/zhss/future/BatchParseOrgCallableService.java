package com.zhss.future;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @Date: 2021/8/11 10:07
 * @Desc:
 */
public class BatchParseOrgCallableService implements Callable<String> {

    String str;

    public BatchParseOrgCallableService(String str) {
        this.str = str;
    }

    @Override
    public String call() throws Exception {


        return str;
    }
}
