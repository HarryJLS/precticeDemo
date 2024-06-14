package com.prectice.leetcode_100_review1.er_fen_cha_zhao;

/**
 * @author JLS
 * @description:
 * @since 2024-06-14 10:48
 */
public class algorithm_153 {

    int min = Integer.MAX_VALUE;
    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        reverse(nums, 0, nums.length-1);
        return min;
    }

    private void reverse (int[] nums, int left, int right) {
        if (left >= right) {
            min = Math.min(min, nums[left]);
            return;
        }
        int mid = (left +right) / 2;
        if (nums[mid] > nums[right]) {
            min = Math.min(min, nums[right]);
            reverse(nums, mid+1, right);
        } else {
            min = Math.min(nums[mid], min);
            reverse(nums, left, mid-1);
        }
    }
}
