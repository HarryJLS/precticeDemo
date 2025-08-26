package com.prectice.leetcode20250826.动态规划2;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 15:17
 */
public class algorithm_152 {

    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            result = Math.max(max, result);
        }
        return result;
    }
}
