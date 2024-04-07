package com.prectice.leetcode_100_review1;

import java.util.LinkedList;

/**
 * @author JLS
 * @description:
 * @since 2024-04-02 15:20
 */
public class algorithm_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int index = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                while (!linkedList.isEmpty() && linkedList.getLast() < nums[i]) {
                    linkedList.removeLast();
                }
                linkedList.addLast(nums[i]);
            }
            if (i == k-1) {
                result[index++] = linkedList.getFirst();
            }
            if (i >= k) {
                if (!linkedList.isEmpty() && linkedList.getFirst() == nums[i-k]) {
                    linkedList.removeFirst();
                }
                while (!linkedList.isEmpty() && linkedList.getLast() < nums[i]) {
                    linkedList.removeLast();
                }
                linkedList.addLast(nums[i]);
                result[index++] = linkedList.getFirst();
            }
        }
        return result;
    }

}
