package com.prectice.leetcode_150;

/**
 * @author JLS
 * @description:
 * @since 2024-03-26 10:46
 */
public class algorithm_80 {

    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 2;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[left + 2] = nums[right];
                left++;
                right++;
            } else {
                right++;
            }
        }
        return left+2;
    }
}
