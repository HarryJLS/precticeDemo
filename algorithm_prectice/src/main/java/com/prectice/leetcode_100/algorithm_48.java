package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-09-27 12:40
 */
public class algorithm_48 {

    public void rotate(int[][] matrix) {

        int length = matrix.length;

        // 先上下翻转
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                swap(matrix, i, j, length - 1 - i, j);
            }
        }
        // 对角线翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }

    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
