package com.prectice.leetcode_100_review2.动态规划;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-12 20:02
 */
public class algorithm_213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robMax(nums, 0, nums.length - 2), robMax(nums, 1, nums.length - 1));
    }
    private int robMax(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int first = nums[left];
        int second = Math.max(nums[left], nums[left+1]);
        int result = second;
        for (int i = left + 2; i <= right; i++) {
            int temp = Math.max(first + nums[i], second);
            first = second;
            second = temp;
            result = Math.max(result, temp);
        }
        return result;
    }
}
