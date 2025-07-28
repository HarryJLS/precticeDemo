package com.prectice.leetcode_100_review2.子串;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-25 17:19
 */
public class algorithm_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                while (!list.isEmpty() && list.getLast() < nums[i]) {
                    list.removeLast();
                }
                list.addLast(nums[i]);
            }
            if (i == k-1) {
                result[0] = list.getFirst();
            }
            if (i >= k) {
                if (!list.isEmpty() && list.getFirst() == nums[i - k]) {
                    list.removeFirst();
                }
                while (!list.isEmpty() && list.getLast() < nums[i]) {
                    list.removeLast();
                }
                list.addLast(nums[i]);
                result[i - k + 1] = list.getFirst();
            }
        }
        return result;
    }
}
