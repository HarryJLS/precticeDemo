package com.prectice.leetcode_150;

/**
 * @author JLS
 * @description:
 * @since 2024-03-26 10:41
 */
public class algorithm_26 {

    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            } else {
                right++;
            }
        }
        return left+1;
    }
}
