package com.prectice.leetcode_100_review1.tu_lun;

/**
 * @author JLS
 * @description:
 * @since 2024-06-05 10:45
 */
public class algorithm_200 {

    public int numIslands(char[][] grid) {

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    reverse(grid, i, j);
                }
            }
        }
        return count;
    }
    private void reverse(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            reverse(grid, i+1, j);
            reverse(grid, i-1, j);
            reverse(grid, i, j+1);
            reverse(grid, i, j-1);
        }
    }
}
