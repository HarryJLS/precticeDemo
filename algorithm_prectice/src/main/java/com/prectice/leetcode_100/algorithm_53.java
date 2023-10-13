package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-09-22 12:17
 */
public class algorithm_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int temp = 0;
        int minValue = 0;
        int maxValue = Integer.MIN_VALUE;
        int tMaxValue = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                flag = true;
            }
            tMaxValue = Math.max(tMaxValue, nums[i]);
            temp += nums[i];
            minValue = Math.min(minValue, temp);
            maxValue = Math.max(temp-minValue, maxValue);
        }
        return flag ? maxValue : tMaxValue;
    }

    public int maxSubArray1(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
