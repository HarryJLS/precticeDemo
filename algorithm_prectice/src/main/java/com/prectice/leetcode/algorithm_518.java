package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2024-03-25 10:35
 */
public class algorithm_518 {

    public int change(int amount, int[] coins) {
        int[] result = new int[amount+1];
        result[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < amount + 1; i++) {
                if (i < coin) {
                    continue;
                }
                result[i] = result[i] + result[i - coin];
            }
        }
        return result[amount];
    }
}
