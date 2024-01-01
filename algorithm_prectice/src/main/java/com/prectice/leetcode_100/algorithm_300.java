package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-21 13:09
 */
public class algorithm_300 {

    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = 1;
        if (nums.length == 1) {
            return 1;
        }

        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            int index = i-1;
            while (index >= 0) {
                if (nums[i] > nums[index]) {
                    dp[i] = Math.max(dp[i], dp[index] + 1);

                }
                index--;
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public int [] lengthOfLIS1(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = 1;
        if (nums.length == 1) {
            return nums;
        }
        int result = 1;
        int tempIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            int index = i-1;
            while (index >= 0) {
                if (nums[i] > nums[index]) {
                    dp[i] = Math.max(dp[i], dp[index] + 1);
                }
                index--;
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            if (dp[i] > result) {
                result = dp[i];
                tempIndex = i;
            }
        }
        int[] resultArray = new int[result];
        resultArray[result-1] = nums[tempIndex];
        int flag = result-1;
        int maxValue = nums[tempIndex];
        for (int i = tempIndex; i >= 0 ; i--) {
            if (dp[i] == flag && maxValue > nums[i]) {
                resultArray[flag-1] = nums[i];
                maxValue = nums[i];
            }
        }
        return resultArray;
    }



    public int lengthOfLIS2(int[] nums) {
        int [] dp = new int[nums.length];
        int maxL = 0;
        for (int num : nums) {
            int indexLeft = 0;
            int indexRight = maxL;
            while (indexLeft < indexRight) {
                int mid = indexLeft + (indexRight - indexLeft) / 2;
                if (dp[mid] < num) {
                    indexLeft = mid+1;
                } else {
                    indexRight = mid;
                }
            }
            dp[indexLeft] = num;
            if (indexLeft == maxL) {
                maxL++;
            }
        }
        return maxL;
    }
}
