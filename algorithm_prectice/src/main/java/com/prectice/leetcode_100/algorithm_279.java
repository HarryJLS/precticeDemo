package com.prectice.leetcode_100;

import java.util.Arrays;

/**
 * @author JLS
 * @description: 动态规划
 * @since 2023-12-20 12:47
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
                if (nums[j -value] != Integer.MAX_VALUE) {
                    nums[j] = Math.min(nums[j - value] + 1, nums[j]);
                }
            }

        }
        return nums[n];
    }
}
