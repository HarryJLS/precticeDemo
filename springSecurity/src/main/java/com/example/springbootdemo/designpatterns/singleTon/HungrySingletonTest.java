package com.example.springbootdemo.designpatterns.singleTon;

/**
 * @author JLS
 * @description: 饿汉模式
 * @since 2023-05-12 17:23
 */
public class HungrySingletonTest {

    public static void main(String[] args) {

        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance1 == instance);
    }
}

class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {

    }
    public static HungrySingleton getInstance() {
        return instance;
    }
}
