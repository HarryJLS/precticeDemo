package com.prectice.leetcode_150;

/**
 * @author JLS
 * @description:
 * @since 2024-03-28 09:29
 */
public class algorithm_122 {

    public int maxProfit(int[] prices) {

        int sum = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                sum += prices[right] - prices[left];
            }
            left = right;
            right++;
        }

        return sum;
    }
}
