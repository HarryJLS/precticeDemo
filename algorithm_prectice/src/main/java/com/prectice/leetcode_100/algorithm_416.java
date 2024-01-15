package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-25 12:14
 */
public class algorithm_416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num :nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int avg = sum / 2;
        int[] dp = new int[avg+1];
        dp[0] = 1;
        for (int num :nums) {
            for (int i = avg; i >= num ; i--) {
                dp[i] += dp[i - num];
                if (dp[i] != 0) {
                    System.out.println(dp[i]);
                }
            }
        }
        System.out.println(dp[avg]);
        return dp[avg] > 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        algorithm_416 algorithm416 = new algorithm_416();
        algorithm416.canPartition(nums);
    }
}
