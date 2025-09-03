package com.prectice.leetcode20250826.动态规划extra;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2025-09-01 17:08
 */
public class algorithm_313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        int[] index = new int[primes.length];
        Arrays.fill(index, 1);
        for (int i = 2; i <= n; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                long value = dp[index[j]] * primes[j];
                if (value < min) {
                    min = value;
                }
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                long value = dp[index[j]] * primes[j];
                if (value == min) {
                    index[j]++;
                }
            }
        }
        return Math.toIntExact(dp[n]);
    }
}
