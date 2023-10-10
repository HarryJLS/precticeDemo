package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-09-25 12:55
 */
public class algorithm_238 {
    public int[] productExceptSelf(int[] nums) {
        int zeroNum = 0;
        int index = 0;
        int result = 1;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                zeroNum++;
                index = i;
            } else {
                result *= nums[i];
            }
        }
        if (zeroNum > 1) {
            return new int[nums.length];
        }
        if (zeroNum == 1) {
            int[] resultData = new int[nums.length];
            resultData[index] = result;
            return resultData;
        }
        if (zeroNum == 0) {
            int left = 1;
            int right = 1;

            int[] resultData = new int[nums.length];
            for (int i = 1; i < nums.length; i++) {
                left *= nums[i-1];
                resultData[i] = left;
            }
            resultData[0] = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                right *= nums[i + 1];
                resultData[i] *= right;
            }
            return resultData;

        }
        return nums;
    }

}
