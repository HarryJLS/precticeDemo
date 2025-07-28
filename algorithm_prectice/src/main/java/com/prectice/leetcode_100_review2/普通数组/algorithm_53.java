package com.prectice.leetcode_100_review2.普通数组;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-28 10:14
 */
public class algorithm_53 {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum - left, max);
            if (left == 0) {
                if (sum < 0) {
                    left = sum;
                }
            } else {
                left = Math.min(left, sum);
            }
        }
        return max;
    }

}
