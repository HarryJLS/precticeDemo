package com.prectice.leetcode20250826.动态规划extra;

/**
 * @author JLS
 * @description: 交错字符
 * @since 2025-08-27 17:36
 */
public class algorithm_97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if (length1 +length2 != length3) {
            return false;
        }
        boolean[][] dp = new boolean[length1+1][length2+1];
        dp[0][0] = true;
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1);
                } else {
                    dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1)) || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
            }
        }
        return dp[length1][length2];
    }
}
