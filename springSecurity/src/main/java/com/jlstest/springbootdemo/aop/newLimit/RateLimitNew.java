package com.jlstest.springbootdemo.aop.newLimit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimitNew {
    // 资源名
    String resourceName();
    // 令牌总数设置
    int permits();
    // 恢复速率，一边填写个数单位默认秒。
    int restoreRate();
}
