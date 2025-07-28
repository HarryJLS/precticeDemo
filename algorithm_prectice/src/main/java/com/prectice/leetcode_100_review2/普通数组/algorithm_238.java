package com.prectice.leetcode_100_review2.普通数组;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-28 11:41
 */
public class algorithm_238 {

    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int left = 1;
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left *= nums[i-1];
            result[i] = left;
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            right *= nums[i+1];
            if (i == 0) {
                result[i] = right;
            } else {
                result[i] *= right;
            }
        }
        return result;

    }
}
