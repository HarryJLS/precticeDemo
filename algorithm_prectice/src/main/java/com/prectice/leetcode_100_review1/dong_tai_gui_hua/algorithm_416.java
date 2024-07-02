package com.prectice.leetcode_100_review1.dong_tai_gui_hua;

/**
 * @author JLS
 * @description:
 * @since 2024-07-02 09:36
 */
public class algorithm_416 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int avg = sum / 2;
        int[] dp = new int[avg+1];
        dp[0] = 1;
        for (int num : nums) {
            // 反着排序主要是因为每个元素只能用一次，假如从小到大，则有可能一个元素用到多次
            for (int i = avg; i >= num ; i--) {
                dp[i] += dp[i - num];
            }
        }
        // 统计的数字越界
        return dp[avg] > 0 || dp[avg] < 0;
    }

    public static void main(String[] args) {
        algorithm_416 algorithm416 = new algorithm_416();
        int[] nums = new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println(algorithm416.canPartition(nums));
    }
}
