package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-17 10:35
 */
public class algorithm_7 {
    public int reverse(int x) {

        long number = 0;
        while (x != 0) {
            number = number*10 + x % 10;
            x /= 10;
        }
        // 判断下越界问题即可
        return (int) number == number ? (int) number : 0;
    }

}
