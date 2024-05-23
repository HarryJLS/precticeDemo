package com.prectice.leetcode_100_review1.jv_zhen;

/**
 * @author JLS
 * @description:
 * @since 2024-05-23 10:44
 */
public class algorithm_48 {

    public void rotate(int[][] matrix) {

        // 先上下翻转
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                swap(matrix, j, i, matrix.length-1 - j, i);
            }
        }

        // 对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
    private void swap(int[][] matrix, int index11, int index12, int index21, int index22) {
        int temp = matrix[index11][index12];
        matrix[index11][index12] = matrix[index21][index22];
        matrix[index21][index22] = temp;
    }
}
