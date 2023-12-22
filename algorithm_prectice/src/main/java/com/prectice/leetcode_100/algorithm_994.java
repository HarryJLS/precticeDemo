package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-11-14 13:04
 */
public class algorithm_994 {

    // 用于标记新鲜橘子的总数
    int sum = 0;
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // 用于统计经历了几分钟腐烂
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                }
            }
        }

        while (infect(grid) != 0) {
            result++;
        }

        return sum == 0 ? result : -1;

    }

    private int infect(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int infactNum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    if (i-1 >= 0 && grid[i-1][j] == 1) {
                        grid[i-1][j] = 3;
                        infactNum ++;
                    }
                    if (i+1 < row && grid[i+1][j] == 1) {
                        grid[i+1][j] = 3;
                        infactNum++;
                    }
                    if (j-1 >= 0 && grid[i][j-1] == 1) {
                        grid[i][j-1] = 3;
                        infactNum++;
                    }
                    if (j+1 < col && grid[i][j+1] == 1) {
                        grid[i][j+1] = 3;
                        infactNum++;
                    }
                }
            }
        }
        if (infactNum > 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 3) {
                        grid[i][j] = 2;
                    }

                }
            }
            sum -= infactNum;
        }
        return infactNum;
    }
}
