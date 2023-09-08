package com.jlstest.springbootdemo.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimit {
    // 资源名称
    String resourceName();
    // 令牌桶初始容量
    int initialCapacity();
    // 令牌桶单位时间填充速率
    int refillRate();
    // 令牌桶填充时间单位
    TimeUnit refillTimeUnit();
}
