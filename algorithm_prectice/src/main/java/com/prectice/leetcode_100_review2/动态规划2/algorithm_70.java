package com.prectice.leetcode_100_review2.动态规划2;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 10:17
 */
public class algorithm_70 {

    public int climbStairs(int n) {
        int first = 1;
        int second = 2;
        if (n <= 2) {
            return n;
        }
        for (int i = 2; i < n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
