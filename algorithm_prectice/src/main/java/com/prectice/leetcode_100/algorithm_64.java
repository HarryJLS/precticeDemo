package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-28 12:20
 */
public class algorithm_64 {

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j ==0) {
                    dp[0][0] = grid[0][0];
                } else if (i == 0) {
                    dp[0][j] =  grid[0][j] + dp[0][j-1];
                }
                else if (j == 0) {
                    dp[i][0] = grid[i][0] + dp[i-1][0];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
