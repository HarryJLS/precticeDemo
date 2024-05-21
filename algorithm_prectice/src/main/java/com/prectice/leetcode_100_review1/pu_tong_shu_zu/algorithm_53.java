package com.prectice.leetcode_100_review1.pu_tong_shu_zu;

/**
 * @author JLS
 * @description:
 * @since 2024-05-20 10:35
 */
public class algorithm_53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        boolean flag = false;
        int temp = Integer.MIN_VALUE;
        int tempSum = 0;
        int maxValue = Integer.MIN_VALUE;
        int minValue = 0;
        for (int num : nums) {
            if (num > 0 ) {
                flag = true;
            }
            temp = Math.max(temp, num);
            tempSum += num;
            minValue = Math.min(minValue, tempSum);
            maxValue = Math.max(maxValue, tempSum - minValue);
        }

        return flag ? maxValue : temp;


    }

    public static void main(String[] args) {
        algorithm_53 algorithm53 = new algorithm_53();
        int[] nums = new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4};

        System.out.println(algorithm53.maxSubArray(nums));
    }
}
