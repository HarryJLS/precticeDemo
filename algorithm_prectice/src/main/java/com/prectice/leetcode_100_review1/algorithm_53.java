package com.prectice.leetcode_100_review1;

/**
 * @author JLS
 * @description:
 * @since 2024-04-02 16:47
 */
public class algorithm_53 {

    /**
     * 核心思想，负数只会越加越小，而正数是越加越大，其次这里要求的是连续子串，对于连续子串求最大值通常 是采用大子串减去小子串
     * 然后又有不同的情况，首先是一串数字全是负数，则最大值只是取其中最大的数字即可 。
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int minValue = 0;
        int maxValue = Integer.MIN_VALUE;
        boolean flag = false;
        int temp = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int num : nums) {
            if (num > 0) {
                flag = true;
            }
            temp = Math.max(num, temp);
            tempSum += num;
            minValue = Math.min(minValue, tempSum);
            maxValue = Math.max(maxValue, tempSum - minValue);
        }
        return flag ? maxValue : temp;
    }

}
