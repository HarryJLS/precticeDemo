package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-09-13 12:37
 */
public class algorithm_26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int left = 0;
        int right = 1;
        while(left < right && right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right++];
            } else {
                right++;
            }
        }
        return left + 1;
    }
}
