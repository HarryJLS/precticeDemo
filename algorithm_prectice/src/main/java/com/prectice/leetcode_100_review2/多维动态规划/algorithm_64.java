package com.prectice.leetcode_100_review2.多维动态规划;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 15:56
 */
public class algorithm_64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] nums = new int[row][col];
        nums[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    nums[i][j] = grid[i][j];
                }
                else if (i == 0) {
                    nums[i][j] = nums[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    nums[i][j] = nums[i-1][j] + grid[i][j];
                } else {
                    nums[i][j] = Math.min(nums[i-1][j], nums[i][j-1]) + grid[i][j];
                }
            }
        }
        return nums[row-1][col-1];
    }
}
