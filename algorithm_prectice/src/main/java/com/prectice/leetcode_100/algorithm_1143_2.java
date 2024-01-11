package com.prectice.leetcode_100;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2024-01-05 14:15
 */
public class algorithm_1143_2 {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return recur(text1, 0, text2, 0);
    }

    private int recur(String text1, int index1, String text2, int index2) {
        if (index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }
        if (dp[index1][index2] > -1) {
            return dp[index1][index2];
        }
        int res = 0;
        if (text1.charAt(index1) == text2.charAt(index2)) {
            res = recur(text1, index1+1, text2, index2+1) + 1;
        } else {
            res = Math.max(recur(text1, index1+1, text2, index2), recur(text1, index1, text2, index2+1));
        }
        dp[index1][index2] = res;
        return res;
    }
}
