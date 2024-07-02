package com.prectice.leetcode_100_review1.dong_tai_gui_hua;

/**
 * @author JLS
 * @description:
 * @since 2024-07-02 10:17
 */
public class algorithm_32 {

    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            int j = i-1-dp[i-1];
            if (j >= 0 && s.charAt(j) == '(') {
                dp[i] = dp[i-1] + 2;
                dp[j] = dp[i];
                if (j-1 >= 0 && dp[j-1] > 0) {
                    dp[i] += dp[j-1];
                    dp[j] = dp[i];
                }
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
