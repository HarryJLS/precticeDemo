package com.prectice.leetcode20250826.动态规划2;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 16:54
 */
public class algorithm_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] nums = new int[temperatures.length];
        nums[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                nums[i] = 1;
            } else {
                int n = i + 1;
                while (n < temperatures.length) {
                    if (temperatures[i] < temperatures[n]) {
                        nums[i] = n - i;
                        break;
                    }
                    if (nums[n] == 0) {
                        nums[i] = 0;
                        break;
                    }
                    if (temperatures[i] == temperatures[n]) {
                        nums[i] = nums[n] + n - i;
                        break;
                    }
                    n++;
                }
            }
        }
        return nums;
    }
}
