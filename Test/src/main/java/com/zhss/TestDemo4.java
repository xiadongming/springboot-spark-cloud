package com.zhss;

import com.zhss.entity.SysUser;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date: 2021/7/8 10:00
 * @Desc:
 */
public class TestDemo4 {


    public static void main(String[] args) {


        SysUser sysUser = new SysUser();
        sysUser.setAuto(sysUser.isAuto2());

        System.out.println(sysUser);
    }


}
