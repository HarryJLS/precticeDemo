package com.prectice.leetcode20250826.动态规划extra;

/**
 * @author JLS
 * @description: 整数拆分
 * @since 2025-08-27 20:49
 */
public class algorithm_343 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {

            int max = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public int integerBreak2(int n) {
        return calculate(n);
    }

    private int calculate(int n) {
        if (n <= 1) {
            return 0;
        }
        int max = 0;
        for (int j = 1; j < n; j++) {
            max = Math.max(max, Math.max(j * (n - j), j * calculate(n - j)));
        }
        return max;
    }
}
