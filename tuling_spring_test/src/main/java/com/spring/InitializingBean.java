package com.spring;

/**
 * @author JLS
 * @description: bean的初始化
 * @since 2023-08-18 21:53
 */
public interface InitializingBean {

    void afterPropertiesSet();
}
