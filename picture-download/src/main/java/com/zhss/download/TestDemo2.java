package com.zhss.download;

/**
 * @Date: 2021/7/20 17:26
 * @Desc:
 */
public class TestDemo2 {

    public static void main(String[] args) {
        
        int abc = 0;

        Integer pageNo = null;


        abc = pageNo;

        //System.out.println(pageNo -1 );//空指针
        System.out.println(abc -1);     //居然是空指针

    }
}

