package com.prectice.leetcode_100_review2.矩阵;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-28 20:28
 */
public class algorithm_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row - 1;
        int y = 0;
        while (x >= 0 && x < row && y >= 0 && y < col) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
