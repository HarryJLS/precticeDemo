package com.prectice.leetcode20250826.动态规划2;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 15:26
 */
public class algorithm_416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int avg = sum / 2;
        int[] dp = new int[avg + 1];
        dp[0] = 1;
        for (int num : nums) {
            if (num > avg) {
                return false;
            }
            for (int i = avg; i >= num; i--) {
                if (dp[i - num] != 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[avg] != 0;

    }
}
