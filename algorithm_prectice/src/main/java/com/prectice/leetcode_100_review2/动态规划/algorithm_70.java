package com.prectice.leetcode_100_review2.动态规划;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-06 20:54
 */
public class algorithm_70 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 2; i < n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
