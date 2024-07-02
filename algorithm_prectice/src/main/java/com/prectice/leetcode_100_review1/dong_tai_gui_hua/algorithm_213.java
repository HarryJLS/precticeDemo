package com.prectice.leetcode_100_review1.dong_tai_gui_hua;

/**
 * @author JLS
 * @description:
 * @since 2024-06-25 09:57
 */
public class algorithm_213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robMax(nums, 0, nums.length - 2), robMax(nums, 1, nums.length - 1));
    }

    private int robMax(int[] nums, int left , int right) {
        int length = right - left + 1;
        if (length == 1) {
            return nums[left];
        }
        if (length == 2) {
            return Math.max(nums[left], nums[left+1]);
        }
        int first = nums[left];
        int second = Math.max(nums[left], nums[left+1]);
        int temp = 0;
        for (int i = left + 2; i <= right ; i++) {
            temp = Math.max(second, first + nums[i]);
            first = second;
            second = temp;
        }
        return second;
    }
}
