package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-09-26 12:54
 */
public class algorithm_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        int rawStart = 0;
        int rawEnd = matrix.length;
        int colStart = 0;
        int colEnd = matrix[0].length;
        while (rawStart < rawEnd && colStart < colEnd) {
            for (int i = colStart; i < colEnd; i++) {
                resultList.add(matrix[rawStart][i]);
            }
            rawStart++;
            if (rawStart >= rawEnd) {
                break;
            }
            for (int i = rawStart; i < rawEnd; i++) {
                resultList.add(matrix[i][colEnd-1]);
            }
            colEnd--;
            if (colStart >= colEnd) {
                break;
            }
            for (int i = colEnd - 1; i >= colStart; i--) {
                resultList.add(matrix[rawEnd-1][i]);
            }
            rawEnd--;
            if (rawStart >= rawEnd) {
                break;
            }
            for (int i = rawEnd - 1; i >= rawStart; i--) {
                resultList.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return resultList;

    }
}
