package com.prectice.leetcode_100_review2.多维动态规划;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 16:04
 */
public class algorithm_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();
        int[][] nums = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    nums[i + 1][j + 1] = nums[i][j] + 1;
                } else {
                    nums[i+ 1][j + 1] = Math.max(nums[i + 1][j], nums[i][j+1]);
                }
            }
        }
        return nums[row][col];

    }
}
