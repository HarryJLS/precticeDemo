package com.prectice.leetcode;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2023-07-13 11:24
 */
public class algorithm_931 {

    /**
     * 解这种题，核心要点是利用动态规划，将复杂的问题分为多个子问题，然后分别求解，最后合并子问题的解，就是原问题的解。
     * 在这题可以利用动态规划，从第二行开始规划到最后一行，保存到达每一个位置所能达到的最小的路径和，比如跳过0行，因为不用计算，从第一行开始计算，
     * 计算出到达第一行每一个节点的最小路径之和，这样计算就比较简单，保持这样计算一直到最后一行就比较简单了，在最后再遍历每一个最后的结果就可以得出需要的值。
     * 由于给的方阵的数字是没有规律的，所以每个节点都是要计算的。
     */
    public int minFallingPathSum(int[][] matrix) {
        // 获取总行数
        int raw = matrix.length;
        // 获取总列数
        int col = matrix[0].length;

        // 声明结果数组。用于保存到达每个节点的
        int[][] temp = new int[raw][col];

        // 数组拷贝
        System.arraycopy(matrix[0], 0, temp[0], 0, col);
        // 遍历每一个节点
        for (int i = 1; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                // 因为每一列都有列可以选择，除了边上的两列
                int min = temp[i-1][j];
                if (j > 0) {
                    min = Math.min(min, temp[i-1][j-1]);
                }
                if (j < col-1) {
                    min = Math.min(min, temp[i-1][j+1]);
                }
                temp[i][j] = min + matrix[i][j];
            }
        }

        int min = temp[raw-1][0];
        for (int t : temp[raw-1]) {
            min = Math.min(min, t);
        }

        return min;

    }
}
