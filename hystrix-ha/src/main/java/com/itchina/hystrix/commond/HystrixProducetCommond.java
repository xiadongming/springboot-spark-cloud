package com.itchina.hystrix.commond;

import com.netflix.hystrix.HystrixCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Date: 2021/4/28 16:25
 * @Desc:
 */
public class HystrixProducetCommond {
    public static void main(String[] args) {

        String path = "D:\\1_music\\sql.sql";
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件

            String line = null;
            while ((line = br.readLine()) != null) {
                String substring = line.substring(line.lastIndexOf("COMMENT '")+9, line.lastIndexOf("',"));
                System.out.println(substring + "、");

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
