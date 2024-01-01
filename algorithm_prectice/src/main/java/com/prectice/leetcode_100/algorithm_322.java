package com.prectice.leetcode_100;

import java.util.Arrays;

/**
 * @author JLS
 * @description: 动态规划
 * @since 2023-12-21 12:23
 */
public class algorithm_322 {

    public int coinChange(int[] coins, int amount) {

        int[] nums = new int[amount+1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        for (int i : coins) {
            for (int j = i; j <= amount; j++) {
                if (nums[j - i] != Integer.MAX_VALUE) {
                    nums[j] = Math.min(nums[j-i] + 1, nums[j]);
                }
            }
        }
        return nums[amount] == Integer.MAX_VALUE ? -1 : nums[amount];
    }
}
