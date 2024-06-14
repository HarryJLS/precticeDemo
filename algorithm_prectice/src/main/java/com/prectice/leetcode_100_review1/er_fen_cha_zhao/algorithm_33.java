package com.prectice.leetcode_100_review1.er_fen_cha_zhao;

/**
 * @author JLS
 * @description:
 * @since 2024-06-14 10:09
 */
public class algorithm_33 {

    int result = -1;
    public int search(int[] nums, int target) {

        reverse(nums, target, 0, nums.length-1);
        return result;
    }

    private void reverse(int[] nums, int target, int left, int right) {
        if (left >= right) {
            if (nums[left] == target) {
                result = left;
            }
            return;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            result = mid;
        } else if (nums[mid] < target) {
            if (nums[mid] <= nums[right]) {
                if (target > nums[right]) {
                    reverse(nums, target, left , mid-1);
                } else {
                    reverse(nums, target, mid+1, right);
                }
            } else {
                reverse(nums, target, mid+1, right);
            }

        } else {
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target) {
                    reverse(nums, target, left , mid-1);
                } else {
                    reverse(nums, target, mid+1, right);
                }
            } else {
                reverse(nums, target, left, mid-1);
            }
        }

    }
}
