package com.prectice.leetcode_100_review1.tu_lun;

/**
 * @author JLS
 * @description:
 * @since 2024-06-05 11:01
 */
public class algorithm_994 {

    int sum = 0;
    public int orangesRotting(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                }
            }
        }
        int result = 0;
        while (injectOrange(grid) != 0) {
            result++;
        }
        return sum == 0 ? result : -1;
    }

    private int injectOrange(int[][] grid) {
        int injectNum = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    if (i+1 < row && grid[i+1][j] == 1) {
                        grid[i+1][j] = 3;
                        injectNum++;
                    }
                    if (i-1 >= 0 && grid[i-1][j] == 1) {
                        grid[i-1][j] = 3;
                        injectNum++;
                    }
                    if (j+1 < col && grid[i][j+1] == 1) {
                        grid[i][j+1] = 3;
                        injectNum++;
                    }
                    if (j-1 >= 0 && grid[i][j-1] == 1) {
                        grid[i][j-1] = 3;
                        injectNum++;
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 3) {
                    grid[i][j] = 2;
                }
            }
        }
        sum -= injectNum;
        return injectNum;
    }
}
