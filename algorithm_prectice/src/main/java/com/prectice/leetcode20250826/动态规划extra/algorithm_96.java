package com.prectice.leetcode20250826.动态规划extra;

/**
 * @author JLS
 * @description: 不同的二叉搜索树
 * @since 2025-08-27 16:50
 */
public class algorithm_96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int left = 0;
            int right = i - 1;
            while (right >= 0) {
                dp[i] += dp[left] * dp[right];
                left++;
                right--;
            }
        }
        return dp[n];
    }
}
