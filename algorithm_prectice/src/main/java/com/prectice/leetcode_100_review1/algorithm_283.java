package com.prectice.leetcode_100_review1;

/**
 * @author JLS
 * @description:
 * @since 2024-04-01 11:04
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

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        algorithm_283 algorithm283 = new algorithm_283();
        int[] nums = new int[]{0,1,0,3,12};
        algorithm283.moveZeroes(nums);
        System.out.println(nums);
    }
}
