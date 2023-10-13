package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-09-18 12:02
 */
public class algorithm_283 {

    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }
        int left = -1,right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                right++;
            } else {
                if (left != right) {
                    nums[++left] = nums[++right];
                } else {
                    left++;
                    right++;
                }
            }
        }
        if (left != right) {
            for (int i = left+1; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }



}
