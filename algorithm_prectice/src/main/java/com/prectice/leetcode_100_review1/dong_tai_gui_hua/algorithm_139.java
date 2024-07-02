package com.prectice.leetcode_100_review1.dong_tai_gui_hua;

import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-26 09:30
 */
public class algorithm_139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (String string : wordDict) {
                if (i >= string.length() && s.startsWith(string, i-string.length())) {
                    nums[i] += nums[i-string.length()];
                }
            }
        }
        return nums[s.length()] >= 1 ? true : false;

    }
}
