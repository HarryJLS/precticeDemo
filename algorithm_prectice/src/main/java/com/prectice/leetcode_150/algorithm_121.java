package com.prectice.leetcode_150;

/**
 * @author JLS
 * @description:
 * @since 2024-03-27 11:32
 */
public class algorithm_121 {
    public int maxProfit(int[] prices) {
        int value = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    continue;
                } else {
                    value = Math.max(value,prices[j] - prices[i]);
                }
            }
        }
        return value;

    }

    public int maxProfit1(int[] prices) {
        int value = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                value = Math.max(prices[right] - prices[left], value);
            } else {
                left = right;
            }
            right++;
        }
        return value;
    }
}
