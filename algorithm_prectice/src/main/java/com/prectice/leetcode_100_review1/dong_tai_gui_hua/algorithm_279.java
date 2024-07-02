package com.prectice.leetcode_100_review1.dong_tai_gui_hua;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2024-06-25 10:16
 */
public class algorithm_279 {
    public int numSquares(int n) {
        int sqrt = (int)Math.sqrt(n);
        int[] nums = new int[n+1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        for (int i = 1; i <= sqrt; i++) {
            int value = i * i;
            for (int j = value; j <= n ; j++) {
                if (nums[j - value] != Integer.MAX_VALUE) {
                    nums[j] = Math.min(nums[j - value] + 1, nums[j]);
                }
            }
        }
        return nums[n];
    }
}
