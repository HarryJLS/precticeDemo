package com.prectice.leetcode_100_review1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2024-04-02 10:57
 */
public class SimpleBlockQueue<T> {

    private final Queue<T> queue = new LinkedList<>();

    private Integer num = 10;



    public void SimpleBlockQueue(Integer num) {
        this.num = num;
    }

    public synchronized T getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }

        T item = queue.remove();
        notify();
        return item;
    }

    public synchronized void setTask(T item) throws InterruptedException {
        while (queue.size() >= num) {
            wait();
        }

        queue.offer(item);
        notify();
    }


}
