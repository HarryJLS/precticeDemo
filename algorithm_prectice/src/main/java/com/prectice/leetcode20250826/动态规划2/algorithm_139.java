package com.prectice.leetcode20250826.动态规划2;

import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 14:23
 */
public class algorithm_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        for (int i = 0; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() && s.startsWith(word, i - word.length())) {
                    nums[i] += nums[i - word.length()];
                }
            }
        }
        return nums[s.length()] > 0;
    }
}
