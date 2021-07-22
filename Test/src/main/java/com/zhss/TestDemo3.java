package com.zhss;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2021/7/8 10:00
 * @Desc:
 */
public class TestDemo3 {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    public static void main(String[] args) {

        System.out.println(ctlOf(4, 3));

        System.out.println(runStateOf(3));

        System.out.println(new Date());


        System.out.println(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()));





    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
}
