package com.prectice.leetcode20250826.动态规划extra;

/**
 * @author JLS
 * @description:  统计各位数字都不同的数字个数
 * @since 2025-09-01 17:42
 */
public class algorithm_357 {

    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n+1];
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + (dp[i-1] - dp[i-2]) * (10 - i + 1);
        }
        return dp[n];
    }
}
