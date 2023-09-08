package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-30 12:32
 */
public class algorithm_89 {

    /**
     * 递归写法
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        return countMax(nums, 0, length - 1);
    }

    private int countMax(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (right == left) {
            return nums[left];
        }
        int value1 = nums[left] + countMax(nums, left + 2, right);
        int value2 = nums[left + 1] + countMax(nums, left + 3, right);

        return Math.max(value1, value2);
    }

    /**
     * 动态规划
     */
    public int rob1(int[] nums) {

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[length - 1], nums[length - 2]);
        }
        if (length == 3) {
            return Math.max(nums[length - 1] + nums[length - 3], nums[length - 2]);
        }
        int[] dp = new int[length];
        dp[length - 1] = nums[length - 1];
        dp[length - 2] = Math.max(nums[length - 1], nums[length - 2]);
        dp[length - 3] = Math.max(nums[length - 1] + nums[length - 3], nums[length - 2]);
        for (int i = length - 4; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], nums[i + 1] + dp[i + 3]);
        }
        return dp[0];
    }



    private int countMax(int[] nums, int index) {
        if (nums == null || index < 0) {
            return 0;
        }
        if (index == 0) {
            return nums[0];
        }
        return Math.max(countMax(nums, index-1), nums[index] + countMax(nums, index-2));
    }

    private int rob3(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[length-1];
    }

    private int rob4(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int temp = 0;
        for (int i = 2; i < length; i++) {
            temp = Math.max(second, nums[i] + first);
            first = second;
            second = temp;
        }
        return second;
    }
}
