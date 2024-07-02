package com.prectice.leetcode_100_review1.dong_tai_gui_hua;

/**
 * @author JLS
 * @description:
 * @since 2024-06-24 10:35
 */
public class algorithm_70 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
