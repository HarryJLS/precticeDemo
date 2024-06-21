package com.prectice.leetcode_100_review1.tan_xin;

/**
 * @author JLS
 * @description:
 * @since 2024-06-20 10:31
 */
public class algorithm_121 {

    public int maxProfit(int[] prices) {
        int value = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[left] <= prices[i]) {
                value = Math.max(prices[i] - prices[left], value);
            } else {
                left = i;
            }
        }
        return value;
    }

}
