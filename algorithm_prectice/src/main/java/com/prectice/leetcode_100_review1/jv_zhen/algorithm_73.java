package com.prectice.leetcode_100_review1.jv_zhen;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2024-05-22 10:04
 */
public class algorithm_73 {

    public void setZeroes(int[][] matrix) {

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (Integer integer : colSet) {
                matrix[i][integer] = 0;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (Integer integer : rowSet) {
                matrix[integer][i] = 0;
            }

        }

    }
}
