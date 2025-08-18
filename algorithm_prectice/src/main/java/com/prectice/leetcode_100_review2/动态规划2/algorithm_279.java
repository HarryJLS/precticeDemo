package com.prectice.leetcode_100_review2.动态规划2;

import java.util.Arrays;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 11:21
 */
public class algorithm_279 {

    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int value = i * i;
            for (int j = value; j <= n; j++) {
                if (nums[j - value] != Integer.MAX_VALUE) {
                    nums[j] = Math.min(nums[j - value] + 1, nums[j]);
                }
            }
        }
        return nums[n];
    }
}
