package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2024-01-05 14:15
 */
public class algorithm_1143_4 {
    public int longestCommonSubsequence(String text1, String text2) {
        return recur(text1, 0, text2, 0);
    }

    private int recur(String text1, int index1, String text2, int index2) {
        if (index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }
        if (text1.charAt(index1) == text2.charAt(index2)) {
            return recur(text1, index1+1, text2, index2+1) + 1;
        } else {
            return Math.max(recur(text1, index1+1, text2, index2), recur(text1, index1, text2, index2+1));
        }
    }
}
