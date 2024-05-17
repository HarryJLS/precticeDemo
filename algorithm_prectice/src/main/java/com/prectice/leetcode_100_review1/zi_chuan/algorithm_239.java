package com.prectice.leetcode_100_review1.zi_chuan;

import java.util.LinkedList;

/**
 * @author JLS
 * @description:
 * @since 2024-05-17 09:59
 */
public class algorithm_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                while (!linkedList.isEmpty() && linkedList.getLast() < nums[i]) {
                    linkedList.removeLast();
                }
                linkedList.addLast(nums[i]);
            }
            if (i == k-1) {
                result[i - k + 1] = linkedList.getFirst();
            }
            if (i >= k) {
                if (!linkedList.isEmpty() && linkedList.getFirst() == nums[i - k]) {
                    linkedList.removeFirst();
                }
                while (!linkedList.isEmpty() && linkedList.getLast() < nums[i]) {
                    linkedList.removeLast();
                }
                linkedList.addLast(nums[i]);
                result[i - k + 1] = linkedList.getFirst();
            }

        }
        return result;
    }
}
