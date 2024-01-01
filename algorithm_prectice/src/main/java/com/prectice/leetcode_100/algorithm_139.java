package com.prectice.leetcode_100;

import java.util.List;

/**
 * @author JLS
 * @description: 动态规划
 * @since 2023-12-21 12:36
 */
public class algorithm_139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        int [] dp = new int[s.length()+1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (String string : wordDict) {
                if (i >= string.length() && s.startsWith(string, i - string.length())) {
                    dp[i] += dp[i-string.length()];
                }
            }
        }
        return dp[s.length()] >= 1 ? true : false;
    }

}
