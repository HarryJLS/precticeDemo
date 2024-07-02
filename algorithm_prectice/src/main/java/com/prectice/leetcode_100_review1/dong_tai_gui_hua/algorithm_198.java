package com.prectice.leetcode_100_review1.dong_tai_gui_hua;

/**
 * @author JLS
 * @description:
 * @since 2024-06-25 09:44
 */
public class algorithm_198 {


    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int temp = 0;
        for (int i = 2; i < nums.length; i++) {
            temp = Math.max(second, first + nums[i]);
            first = second;
            second = temp;
        }
        return second;
    }

}
