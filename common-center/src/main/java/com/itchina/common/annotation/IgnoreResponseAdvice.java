package com.itchina.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date: 2021/4/7 22:20
 * @Desc: 忽略统一响应格式
 */
@Target({ElementType.TYPE,ElementType.METHOD}) //表示该注解可以打在类和方法上
@Retention(RetentionPolicy.RUNTIME) //运行时起作用
public @interface IgnoreResponseAdvice {
}
