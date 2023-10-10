package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-09-27 12:51
 */
public class algorithm_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int raw = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[raw-1][col-1]) {
            return false;
        }

        int rawStart = -1;
        int rawEnd = -1;
        int colStart = -1;
        int colEnd = -1;
        for (int i = 0; i < raw; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][col-1]) {
                if (rawStart == -1) {
                    rawStart = i;
                }
                rawEnd = i;
            }
        }
        for (int i = 0; i < col; i++) {
            if (target >=matrix[0][i] && target <= matrix[raw-1][i]) {
                if (colStart == -1) {
                    colStart = i;
                }
                colEnd = i;
            }

        }

        if (rawStart == -1 || colStart == -1) {
            return false;
        }

        boolean flag = false;
        for (int i = rawStart; i <= rawEnd; i++) {
            if (flag) {
                break;
            }
            for (int j = colStart; j <= colEnd; j++) {
                if (matrix[i][j] == target) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int raw = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[raw-1][col-1]) {
            return false;
        }
        int rawIndex = raw - 1;
        int colIndex = 0;
        while (rawIndex >= 0 && colIndex < col) {
            if (matrix[rawIndex][colIndex] > target) {
                rawIndex--;
            } else if (matrix[rawIndex][colIndex] < target) {
                colIndex++;
            } else {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[1][2];
        matrix[0][0] = -1;
        matrix[0][1] = 3;
        algorithm_240 algorithm240 = new algorithm_240();
        System.out.println(algorithm240.searchMatrix(matrix, 1));
    }
}
