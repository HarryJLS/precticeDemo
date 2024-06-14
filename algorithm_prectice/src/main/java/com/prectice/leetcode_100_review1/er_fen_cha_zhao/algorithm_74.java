package com.prectice.leetcode_100_review1.er_fen_cha_zhao;

/**
 * @author JLS
 * @description:
 * @since 2024-06-13 10:18
 */
public class algorithm_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row - 1;
        int y = 0;
        while (x < row && x >= 0 && y < col && y >= 0) {
            if (matrix[x][y] > target) {
                x--;
            } else if (matrix[x][y] < target) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }
}
