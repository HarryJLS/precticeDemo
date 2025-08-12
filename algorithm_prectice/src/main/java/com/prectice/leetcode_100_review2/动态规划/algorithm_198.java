package com.prectice.leetcode_100_review2.动态规划;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-12 19:50
 */
public class algorithm_198 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int result = Math.max(nums[0], nums[1]);
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(first + nums[i], second);
            first = second;
            second = temp;
            result = Math.max(result, temp);
        }
        return result;
    }

}
