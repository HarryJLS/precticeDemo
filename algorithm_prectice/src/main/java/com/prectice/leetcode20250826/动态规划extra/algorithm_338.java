package com.prectice.leetcode20250826.动态规划extra;

/**
 * @author JLS
 * @description: 比特位计数
 * @since 2025-08-27 20:41
 */
public class algorithm_338 {

    public int[] countBits(int n) {
        int[] bit = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bit[i] = countOne(i);
        }
        return bit;
    }
    private int countOne(int x) {
        int sum = 0;
        while (x > 0) {
            x &= (x-1);
            sum++;
        }
        return sum;
    }
}
