package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-20 12:34
 */
public class algorithm_198 {

    public int rob(int[] nums) {
        return robMax(nums, nums.length);
    }

    private int robMax(int[] nums, int length) {
        if (length == 1) {
            return nums[0];
        }

        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int temp = 0;
        for (int i = 2; i < length; i++) {
            temp = Math.max(second, nums[i] + first);
            first = second;
            second = temp;
        }
        return second;
    }
}
