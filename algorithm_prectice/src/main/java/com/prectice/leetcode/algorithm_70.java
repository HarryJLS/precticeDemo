package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-09-12 12:48
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
        for (int i = 3; i <= n ; i++) {
            temp = first +second;
            first = second;
            second = temp;
        }
        return second;
    }

    public int climbStairs1(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int temp = 0;
        for (int i = 3; i <= n ; i++) {
            temp = first +second;
            first = second;
            second = temp;
        }
        return second;
    }
}
