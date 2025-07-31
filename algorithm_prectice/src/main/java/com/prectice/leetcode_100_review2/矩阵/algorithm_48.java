package com.prectice.leetcode_100_review2.矩阵;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-28 20:11
 */
public class algorithm_48 {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int temp = 0;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[length - i - 1][j];
                matrix[length - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        }

    }
}
