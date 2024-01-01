package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-18 12:20
 */
public class algorithm_121 {

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = 0;
        if (prices.length == 1) {
            return max;
        }
        while (right < prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
            } else {
                max = Math.max(max, prices[right] - prices[left]);
            }
            right++;
        }
        return max;
    }
}
