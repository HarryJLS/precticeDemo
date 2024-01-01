package com.prectice.leetcode_100;

import java.util.PriorityQueue;

/**
 * @author JLS
 * @description:
 * @since 2023-12-13 12:31
 */
public class algorithm_215 {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }

        }
        return minHeap.peek();

    }

    public static void main(String[] args) {
        System.out.println(5 >>> 1);
        System.out.println(4 >>> 1);
        System.out.println(3 >>> 1);
    }
}
