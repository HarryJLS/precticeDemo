package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-11 10:23
 */
public class algorithm_1911 {

    public long maxAlternatingSum1(int[] nums) {

        long max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max += Math.max(nums[i] - nums[i-1], 0);
        }
        return max;


    }

    public static long maxAlternatingSum2(int[] nums) {
        long max = 0;
        // 设置标记值，用于标记是到了加法还是减法
        int flag = 1;
        for (int i = 0; i < nums.length; i++) {
            // 保证两两组合的时候，差值是正值 当flag == 1的时候，说明已有里面的组合个数为偶数，但是题目要求的数量是奇数，
            if (flag == 1 && (i == nums.length - 1|| nums[i] > nums[i+1] )) {
                flag = 0;
                max += nums[i];
            }

            if (i < nums.length - 1 && flag == 0 && nums[i] < nums[i+1]) {
                flag = 1;
                max -= nums[i];
            }

        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,5,3};
        System.out.println(maxAlternatingSum2(nums));
    }
}
