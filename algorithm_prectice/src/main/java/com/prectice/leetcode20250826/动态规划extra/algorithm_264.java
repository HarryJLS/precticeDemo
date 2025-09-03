package com.prectice.leetcode20250826.动态规划extra;

/**
 * @author JLS
 * @description: 丑数
 * @since 2025-09-01 16:36
 */
public class algorithm_264 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            int num = Math.min(num2, Math.min(num3, num5));
            dp[i] = num;
            if (num == num2) {
                p2++;
            }
            if (num == num3) {
                p3++;
            }
            if (num == num5) {
                p5++;
            }
        }
        return dp[n];
    }

}
