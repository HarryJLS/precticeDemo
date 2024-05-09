package com.prectice.leetcode_100_review1.duo_wei_dong_tai_gui_hua;

/**
 * @author JLS
 * @description:
 * @since 2024-05-09 11:20
 */
public class algorithm_64 {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }

        }
        return grid[row-1][col-1];
    }
}
