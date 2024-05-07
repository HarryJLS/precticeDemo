package com.prectice.leetcode_100_review1.hua_dong_chuang_kou;

import java.util.LinkedList;

/**
 * @author JLS
 * @description: 滑动时间窗口
 * @since 2024-05-07 10:22
 */
public class SlidTimeWindows {

    private static Integer capicity = 10;
    private static final LinkedList<Long> list = new LinkedList<>();
    private static Long counter;
    private static Long yuzhi = 100L;

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                try {
                    if (!docheck()) {
                        throw new Exception("超出阈值");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public static void addCounter() {
        counter++;
    }


    private static boolean docheck() throws InterruptedException {
        Thread.sleep(100);
        list.addLast(counter);
        if (list.size() > capicity) {
            list.removeFirst();
        }
        if (list.peekLast() - list.peekFirst() > yuzhi) {
            return false;
        }
        return true;

    }
}
