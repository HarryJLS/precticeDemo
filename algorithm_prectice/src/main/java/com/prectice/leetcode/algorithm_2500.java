package com.prectice.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2023-07-27 11:16
 */
public class algorithm_2500 {

    public int deleteGreatestValue(int[][] grid) {

        int row = grid.length;
        int rol = grid[0].length;
        for (int i = 0; i < row; i++) {
            Arrays.sort(grid[i]);
        }

        int result = 0;
        for (int i = 0; i < rol; i++) {
            int temp = 0;
            for (int j = 0; j < row; j++) {
                temp = Math.max(grid[j][i], temp);
            }
            result += temp;
        }
        return result;
    }
}
