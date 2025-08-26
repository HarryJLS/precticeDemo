package com.prectice.leetcode20250826.动态规划2;

import java.util.Map;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 15:10
 */
public class algorithm_300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    result = Math.max(dp[i], result);
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
