package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2024-03-25 10:50
 */
public class algorithm_80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int num = 0;
        int left = 0;
        int right = 2;
        while (left < right - 1 && right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                nums[left+2] = nums[right];
                left++;
                right++;
            }
        }
        return left+2;
    }
}
