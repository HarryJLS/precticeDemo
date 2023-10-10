package com.testspring.service;

import com.spring.BeanPostProcessor;
import com.spring.Component;
import com.spring.JlsValue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author JLS
 * @description:
 * @since 2023-08-18 21:59
 */
@Component
public class JlsBeanPostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws IllegalAccessException {

            for (Field field : bean.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(JlsValue.class)) {
                    field.setAccessible(true);
                    field.set(bean, field.getAnnotation(JlsValue.class).value());
                }
            }
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) {

            if (beanName.equals("userService")) {
                // 生成代理对象
                Object proxyInstance = Proxy.newProxyInstance(JlsBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // 切面
                        System.out.println("切面逻辑");
                        return method.invoke(bean, args);
                    }
                });
                return proxyInstance;
            }

            return bean;
        }

}
