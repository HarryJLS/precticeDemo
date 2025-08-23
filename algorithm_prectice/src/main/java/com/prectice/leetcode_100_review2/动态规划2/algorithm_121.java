package com.prectice.leetcode_100_review2.动态规划2;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-21 19:28
 */
public class algorithm_121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                result = Math.max(result, prices[i] - min);
            }
        }
        return result;
    }
}
