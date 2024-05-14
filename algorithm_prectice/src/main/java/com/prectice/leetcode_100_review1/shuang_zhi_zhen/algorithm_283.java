package com.prectice.leetcode_100_review1.shuang_zhi_zhen;

/**
 * @author JLS
 * @description:
 * @since 2024-05-14 10:29
 */
public class algorithm_283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                right++;
            } else {
                swap(nums, left, right);
                left++;
                right++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }



}
