package com.prectice.leetcode_100_review2.动态规划;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-15 15:46
 */
public class algorithm_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        int avg = sum / 2;
        int[] temp = new int[avg + 1];
        temp[0] = 1;
        for (int num : nums) {
            for (int i = avg; i >= num ; i--) {
                if (temp[i - num] != 0) {
                    temp[i] = temp[i] + temp[i - num];
                }
            }
        }
        return temp[avg] != 0;
    }

}
