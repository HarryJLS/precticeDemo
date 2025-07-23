package com.prectice.leetcode_100_review1.other;

import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author JLS
 * @description: 多线程模拟赛马
 * @since 2024-07-16 10:23
 */
public class HorseRacingDemo {

    public static final int HORSE_NUM = 10;

    public static final CountDownLatch startLatch = new CountDownLatch(HORSE_NUM);

    public static final CountDownLatch endLatch = new CountDownLatch(HORSE_NUM);

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(16);
        Long now = System.currentTimeMillis();
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Horse horse = new Horse(i + "号小马");
            horses.add(horse);
            new Thread(horse).start();
        }
        endLatch.await();
        Collections.sort(horses);
        for (Horse hors : horses) {
            System.out.println(hors.getName() + "用时" + (hors.time - now) + "ms");
        }
    }


    public static class  Horse implements Runnable, Comparable<Horse> {

        private String name;

        private long time;

        public Horse(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                startLatch.countDown();
                startLatch.await();
                Thread.sleep((long) (Math.random() * 10000));
                time = System.currentTimeMillis();
                endLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int compareTo(Horse horse) {
            return Long.compare(this.time, horse.time);
        }
    }
}
