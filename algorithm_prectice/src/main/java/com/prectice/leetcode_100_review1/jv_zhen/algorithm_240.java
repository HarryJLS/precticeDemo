package com.prectice.leetcode_100_review1.jv_zhen;

/**
 * @author JLS
 * @description:
 * @since 2024-05-23 11:09
 */
public class algorithm_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        if (matrix[0][0] > target || matrix[rowLength-1][colLength-1] < target) {
            return false;
        }

        int row = rowLength - 1;
        int col = 0;
        while (row >= 0 && col < colLength) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            }
        }
        return false;
    }
}
