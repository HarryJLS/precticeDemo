package com.prectice.leetcode_100_review1.jv_zhen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-05-22 10:11
 */
public class algorithm_54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> resultList = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int row = 0;
        int col = 0;
        while(rowStart <= rowEnd && colStart <= colEnd) {

            if (row == rowStart && col == colStart) {
                for (int i = colStart; i <= colEnd ; i++) {
                    resultList.add(matrix[row][i]);
                }
                rowStart++;
                row++;
                col = colEnd;
            }
            if (rowStart > rowEnd) {
                break;
            }
            if (row == rowStart && col == colEnd) {
                for (int i = rowStart; i <= rowEnd ; i++) {
                    resultList.add(matrix[i][col]);
                }
                colEnd--;
                col--;
                row = rowEnd;
            }
            if (colStart > colEnd) {
                break;
            }
            if (row == rowEnd && col == colEnd) {
                for (int i = colEnd; i >= colStart ; i--) {
                    resultList.add(matrix[row][i]);
                }
                rowEnd--;
                row--;
                col = colStart;
            }
            if (rowStart > rowEnd) {
                break;
            }
            if (row == rowEnd && col == colStart) {
                for (int i = rowEnd; i >= rowStart ; i--) {
                    resultList.add(matrix[i][col]);
                }
                colStart++;
                col++;
                row = rowStart;
            }
            if (colStart > colEnd) {
                break;
            }

        }
        return resultList;
    }
}
