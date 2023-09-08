package com.example.springbootdemo.designpatterns.singleTon;

/**
 * @author JLS
 * @description: 静态内部类。使用类加载机制来保证单例，也是一种懒加载
 * @since 2023-05-12 17:29
 */
public class InnerClassSingletonTest {

    public static void main(String[] args) {

        InnerClassSingleton instance = InnerClassSingleton.getInstance();
    }
}

class InnerClassSingleton {
    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
    private InnerClassSingleton() {

    }
    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }
}
