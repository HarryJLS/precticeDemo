package com.prectice.leetcode_100_review2.普通数组;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-28 11:28
 */
public class algorithm_189 {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k > length) {
            k %= length;
        }
        int[] temp = new int[length - k];
        for (int i = 0; i < length - k; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = nums[i + length - k];
        }
        for (int i = k; i < length; i++) {
            nums[i] = temp[i - k];
        }
    }
}
