package com.prectice.other_prectice;

import java.util.LinkedList;

/**
 * @author JLS
 * @description: 滑动时间窗口算法
 * @since 2024-05-05 15:52
 */
public class moveBucket {

    public static LinkedList<Long> data = new LinkedList<>();

    public static long limt = 10;

    public static long capacity = 10;

    public static long counter = 0;

    public static void main(String[] args) {
        // 线程启动
        new Thread(() -> {
            while (true) {
                try {
                    if (doCheck()) {
                        System.out.println("正常");
                    } else {
                        System.out.println("异常");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(50);
                    addCounter();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }
        }}).start();
    }

    // 用于模拟数据的添加
    public static void addCounter() {
        counter++;
    }

    public static boolean doCheck() throws InterruptedException {
        while (true) {
            Thread.sleep(1000/10);
            data.add(counter);
            if (data.size() > capacity) {
                data.removeFirst();
            }
            if (data.peekLast() - data.peekFirst() < limt) {
                return true;
            } else {
                return false;
            }
        }
    }
}
