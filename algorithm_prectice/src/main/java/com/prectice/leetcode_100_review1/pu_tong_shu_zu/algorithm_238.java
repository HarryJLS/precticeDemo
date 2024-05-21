package com.prectice.leetcode_100_review1.pu_tong_shu_zu;

/**
 * @author JLS
 * @description:
 * @since 2024-05-21 10:02
 */
public class algorithm_238 {

    public int[] productExceptSelf(int[] nums) {
        int zeroNum = 0;
        int left = 1;
        int right = 1;
        int sum = 1;
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                zeroIndex = i;
            } else {
                sum *= nums[i];
            }
        }
        if (zeroNum > 1) {
            return new int[nums.length];
        }
        if (zeroNum == 1) {
            int[] result = new int[nums.length];
            result[zeroIndex] = sum;
            return result;
        }
        if (zeroNum < 1) {
            int[] result = new int[nums.length];
            result[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                left *= nums[i-1];
                result[i] = left;
            }
            for (int i = nums.length - 2; i >= 0 ; i--) {
                right *= nums[i+1];
                result[i] *= right;
            }
            return result;

        }
        return new int[nums.length];

    }
}
