package com.prectice.leetcode_100_review1.dui;

import java.util.PriorityQueue;

/**
 * @author JLS
 * @description:
 * @since 2024-06-19 10:44
 */
public class algorithm_215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minQueue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (minQueue.peek() < nums[i]) {
                minQueue.poll();
                minQueue.offer(nums[i]);
            }
        }
        return minQueue.peek();
    }
}
