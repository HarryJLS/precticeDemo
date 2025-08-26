package com.prectice.leetcode20250826.动态规划2;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-21 19:40
 */
public class algorithm_309 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] nums = new int[n][3];
        nums[0][0] = -prices[0];
        /**
         * 这里nums[i][0] 指代持有股票
         * nums[i][1] 指代未持有股票且处于冷冻期
         * nums[i][2] 指代未持有股票且没有处于冷冻期
         */
        for (int i = 1; i < n; i++) {
            nums[i][0] = Math.max(nums[i - 1][0], nums[i - 1][2] - prices[i]);
            nums[i][1] = nums[i - 1][0] + prices[i];
            nums[i][2] = Math.max(nums[i - 1][1], nums[i - 1][2]);
        }
        return Math.max(nums[n - 1][1], nums[n - 1][2]);
    }
}
