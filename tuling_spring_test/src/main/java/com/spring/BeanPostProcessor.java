package com.spring;

/**
 * @className: BeanPostProcessor
 * @Description: TODO
 * @author: JLS
 * @date: 2023/8/18 21:57
 */
public interface BeanPostProcessor {

    // 初始化前
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws IllegalAccessException {
        return bean;
    }

    // 初始化后
    default Object postProcessAfterInitialization(Object bean, String beanName) {
//        System.out.println();
        return bean;
    }
}
