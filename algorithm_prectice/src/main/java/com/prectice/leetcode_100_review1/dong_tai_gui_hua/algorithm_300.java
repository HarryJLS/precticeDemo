package com.prectice.leetcode_100_review1.dong_tai_gui_hua;

/**
 * @author JLS
 * @description:
 * @since 2024-06-28 10:04
 */
public class algorithm_300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = i-1;
            while (index >= 0) {
                if (nums[i] > nums[index]) {
                    dp[i] = Math.max(dp[index] + 1, dp[i]);
                }
                index--;
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            result = Math.max(dp[i], result);
        }

        return result;
    }
}
