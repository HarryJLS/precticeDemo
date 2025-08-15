package com.prectice.leetcode_100_review2.动态规划;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-15 14:55
 */
public class algorithm_152 {

    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(num, num * max);
            min = Math.min(num, num * min);
            result = Math.max(result, max);
        }
        return result;
    }
}
