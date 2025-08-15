package com.prectice.leetcode_100_review2.动态规划;

import java.util.Arrays;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-14 20:15
 */
public class algorithm_279 {

    public int numSquares(int n) {
        int[] nums = new int[n+1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int value = i * i;
            for (int j = value; j <= n ; j++) {
                int index = j - value;
                if (nums[index] != Integer.MAX_VALUE) {
                    nums[j] = Math.min(nums[j], nums[index] + 1);
                }
            }
        }
        return nums[n];
    }
}
