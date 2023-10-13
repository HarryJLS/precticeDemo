package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2023-09-26 12:22
 */
public class algorithm_73 {

    public void setZeroes(int[][] matrix) {
        Set<Integer> colList = new HashSet<>();
        Set<Integer> rawList = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rawList.add(i);
                    colList.add(j);
                }
            }
        }
        for (int raw : rawList) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[raw][i] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int col : colList) {
                matrix[i][col] = 0;
            }
        }

    }
}
