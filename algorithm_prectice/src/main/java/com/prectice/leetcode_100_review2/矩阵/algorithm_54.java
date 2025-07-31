package com.prectice.leetcode_100_review2.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-28 19:23
 */
public class algorithm_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int rowMax = matrix.length-1;
        int rowMin = 0;
        int colMax = matrix[0].length-1;
        int colMin = 0;
        int rowIndex = 0;
        int colIndex = 0;
        List<Integer> result = new ArrayList<>();
        int flag = 0;
        while (rowIndex >= rowMin && rowIndex <= rowMax && colIndex >= colMin && colIndex <= colMax) {
            result.add(matrix[rowIndex][colIndex]);
            if (flag == 0) {
                if (colIndex < colMax) {
                    colIndex++;
                } else {
                    flag = 1;
                    rowMin++;
                    rowIndex++;
                }
                continue;
            }
            if (flag == 1) {
                if (rowIndex < rowMax) {
                    rowIndex++;
                } else {
                    flag = 2;
                    colMax--;
                    colIndex--;
                }
                continue;
            }
            if (flag == 2) {
                if (colIndex > colMin) {
                    colIndex--;
                } else {
                    flag = 3;
                    rowMax--;
                    rowIndex--;
                }
                continue;
            }
            if (flag == 3) {
                if (rowIndex > rowMin) {
                    rowIndex--;
                } else {
                    flag = 0;
                    colMin++;
                    colIndex++;
                }
                continue;
            }
            result.add(matrix[rowIndex][colIndex]);
        }
        return result;
    }
}
