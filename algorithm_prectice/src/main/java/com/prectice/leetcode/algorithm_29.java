package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2024-03-20 10:19
 */
public class algorithm_29 {

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 同符号则大于0
        boolean flag = (dividend ^ divisor) >= 0;
        int result = 0;
        long t = Math.abs((long)dividend);
        long s = Math.abs((long)divisor);
        for (int i = 31; i >= 0; i--) {
            if (t >> i >= s) {
                result += 1 << i;
                t -= s << i;
            }
        }
        return flag ? result : -result;

    }

    public static void main(String[] args) {
        algorithm_29 algorithm29 = new algorithm_29();
        System.out.println(Math.abs(-2147483648));
        System.out.println(algorithm29.divide(-2147483648, 1));
    }
}
