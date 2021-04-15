package com.itchina.seckill.entity;

import java.io.Serializable;

/**
 * @Date: 2021/4/13 7:48
 * @Desc: 专门给秒杀用户使用
 */
public class SeckillUserInfo implements Serializable {

    private String name;
    private String age;
    private String addRess;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddRess() {
        return addRess;
    }

    public void setAddRess(String addRess) {
        this.addRess = addRess;
    }

    @Override
    public String toString() {
        return "SeckillUserInfo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", addRess='" + addRess + '\'' +
                '}';
    }
}
