package com.prectice.leetcode_100_review2.双指针;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-23 19:59
 */
public class algorithm_283 {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                right++;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            }
        }
    }
}
