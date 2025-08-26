package com.prectice.leetcode_100_review2;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-25 20:33
 */
public class tes2 {

    public int[][] temp;
    public boolean calculate(int[] nums) {
        temp = new int[nums.length][nums.length];
        return solve(nums, 0, nums.length - 1) > 0;
    }

    private int solve(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        if (temp[left][right] != 0) {
            return temp[left][right];
        }
        int selectLeft = nums[left] - solve(nums, left + 1, right);
        int selectRight = nums[right] - solve(nums, left, right - 1);
        int result = Math.max(selectLeft, selectRight);
        temp[left][right] = result;
        return result;
    }


}
