package org.example.syncdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JLS
 * @description:
 * @since 2023-10-30 19:40
 */
public class SyncDemo {

    private static int count = 0;

    private static ReentrantLock lock = new ReentrantLock(true);

    public static void increment() {

        count++;
    }
    public static void incrementSafe() {

        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                incrementSafe();
                System.out.println("线程1成功");
            }
        }, "t1");
        synchronized (SyncDemo.class) {
            t1.start();
            t1.wait();
        }
       
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                incrementSafe();
                System.out.println("线程2成功");
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
