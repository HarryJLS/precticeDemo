package com.prectice.leetcode20250826.动态规划extra;

/**
 * @author JLS
 * @description: 编辑距离
 * @since 2025-08-27 14:28
 */
public class algorithm_72 {

    public static int minDistance(String word1, String word2) {
        int row = word1.length();
        int col = word2.length();
        if (row * col == 0) {
            return row + col;
        }
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= col; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <=col; j++) {
                int rowData = dp[i-1][j] + 1;
                int colData = dp[i][j - 1] + 1;
                int rowColData = dp[i - 1][j - 1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1);
                dp[i][j] = Math.min(rowColData, Math.min(rowData, colData));
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }


}
