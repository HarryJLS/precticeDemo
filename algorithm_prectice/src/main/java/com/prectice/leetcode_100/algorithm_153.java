package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-06 12:20
 */
public class algorithm_153 {

    int min = Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        test(nums, 0, nums.length-1);
        return min;

    }

    private void test(int[] nums, int left, int right) {
        if (left >= right) {
            min = Math.min(min, nums[left]);
            return;
        }

        int mid = (left + right) / 2;
        if (nums[mid] < nums[right]) {
            min = Math.min(min, nums[mid]);
            test(nums, left, mid - 1);
        } else {
            min = nums[left];
            test(nums, mid + 1, right);
        }
    }
}
