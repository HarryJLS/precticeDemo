package com.prectice.leetcode_100_review2.矩阵;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-28 19:15
 */
public class algorithm_73 {


    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> rowSet = new HashSet();
        Set<Integer> colSet = new HashSet();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        if (rowSet.isEmpty()) {
            return;
        }
        for (Integer i : rowSet) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < row; i++) {
            for (Integer j : colSet) {
                matrix[i][j] = 0;
            }
        }
    }
}
