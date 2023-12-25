package com.prectice.leetcode_100;

import java.util.PriorityQueue;

/**
 * @author JLS
 * @description:
 * @since 2023-12-14 12:19
 */
public class algorithm_295 {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> (e2 - e1 > 0 ? 1 : -1));
    int leftSum = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((e1, e2) -> (e2 - e1 < 0 ? 1 : -1));
    int rightSum = 0;

    boolean flag = false;
    double result = 0;

    public algorithm_295() {

    }

    public void addNum(int num) {
        flag = false;
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.offer(num);
            leftSum++;
            return;
        }
        if (leftSum > rightSum) {
            if (num < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            rightSum++;
        } else {
            if (num > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
            leftSum++;
        }
    }

    private void checkAndSwap() {
        while (maxHeap.peek() > minHeap.peek()) {
            maxHeap.offer(minHeap.poll());
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (flag) {
            return result;
        }
        flag = true;
        if (leftSum < rightSum) {
            result = minHeap.peek();
            return result;
        } else if (leftSum > rightSum) {
            result = maxHeap.peek();
            return result;
        } else {
            result = (minHeap.peek() + maxHeap.peek()) * 1.0d / 2.0d;
            return result;
        }
    }

}
