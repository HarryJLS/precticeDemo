package com.prectice.leetcode20250826.动态规划2;

/**
 * @author JLS
 * @description:
 * @since 2025-08-25 21:48
 */
public class algorithm_486 {

    public int[][] temp;
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        temp = new int[n][n];
        return solve(nums, 0, nums.length - 1) >= 0;
    }
    private int solve(int[] nums, int left, int right) {
        if (left >= right) {
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
