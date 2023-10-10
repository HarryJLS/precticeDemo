package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-09-12 12:21
 */
public class algorithm_198 {
    public int rob(int[] nums) {

        return robMax(nums, nums.length-1);
    }

    private int robMax(int[] nums, int index) {
        if (nums.length == 0) {
            return 0;
        }
        if (index < 0) {
            return 0;
        }
        if (index == 0)
        {
            return nums[0];
        }
        return Math.max(robMax(nums, index-1), nums[index] + robMax(nums, index-2));

    }

    private int robMax1(int[] nums, int index) {
        if (nums.length == 0) {
            return 0;
        }
        if (index < 0) {
            return 0;
        }
        if (index == 0)
        {
            return nums[0];
        }
        int[] re = new int[nums.length];
        re[0] = nums[0];
        re[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            re[i] = Math.max(re[i-1], nums[i] + re[i-2]);
        }
        return re[nums.length-1];
    }

    private int robMax2(int[] nums, int index) {
        if (nums.length == 0) {
            return 0;
        }
        if (index < 0) {
            return 0;
        }
        if (index == 0)
        {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int temp = 0;
        for (int i = 2; i < nums.length; i++) {
            temp = Math.max(second, first + nums[i]);
            first = second;
            second = temp;
        }
        return second;
    }

}
