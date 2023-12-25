package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-04 12:32
 */
public class algorithm_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = col -1;
        while (x >= 0 && x < row && y >= 0 && y < col) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }
}
