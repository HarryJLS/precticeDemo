package com.prectice.leetcode_100_review2.动态规划2;

import java.util.Arrays;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 14:11
 */
public class algorithm_322 {

    public int coinChange(int[] coins, int amount) {
        int[] nums = new int[amount + 1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (nums[i - coin] != Integer.MAX_VALUE) {
                    nums[i] = Math.min(nums[i - coin] + 1, nums[i]);
                }
            }
        }
        return nums[amount] == Integer.MAX_VALUE ? -1 : nums[amount];
    }
}
