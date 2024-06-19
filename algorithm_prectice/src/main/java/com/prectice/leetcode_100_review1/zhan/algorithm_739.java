package com.prectice.leetcode_100_review1.zhan;

/**
 * @author JLS
 * @description:
 * @since 2024-06-19 10:06
 */
public class algorithm_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        result[length-1] = 0;
        for (int i = length-2; i >= 0 ; i--) {
            if (temperatures[i] < temperatures[i+1]) {
                result[i] = 1;
            } else {
                int n = i+1;
                while (n < length) {
                    if (temperatures[i] < temperatures[n]) {
                        result[i] = n - i;
                        break;
                    }
                    if (result[n] == 0) {
                        result[i] = 0;
                        break;
                    }
                    n = n + result[n];
                }
            }
        }
        return result;
    }

}
