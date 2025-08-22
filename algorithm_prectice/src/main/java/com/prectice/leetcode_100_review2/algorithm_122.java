package com.prectice.leetcode_100_review2;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-21 19:35
 */
public class algorithm_122 {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int value = prices[i] - prices[i-1];
            if (value > 0) {
                sum += value;
            }
        }
        return sum;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] nums = new int[n][2];
        nums[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            nums[i][0] = Math.max(nums[i-1][0], nums[i-1][1] - prices[i]);
            nums[i][1] = Math.max(nums[i-1][0] + prices[i],nums[i-1][1]);
        }
        return Math.max(nums[n-1][0], nums[n-1][1]);


    }
}
