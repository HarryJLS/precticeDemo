package com.example.springbootdemo.designpatterns.singleTon;

/**
 * @author JLS
 * @description: 单例模式中的懒汉模式 需要考虑线程安全问题，以及字节码的指令重排问题，使用volatile解决
 * @since 2023-05-12 16:58
 */
public class LazySingletonTest {

    public static void main(String[] args) {

//        LazySingleton instance = LazySingleton.getInstance();
//        LazySingleton instance1 = LazySingleton.getInstance();
//        System.out.println(instance1 == instance);

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

    }
}
class LazySingleton {

    private volatile static LazySingleton instance;
    private LazySingleton() {

    }
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
