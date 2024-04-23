package com.prectice.leetcode_150;

/**
 * @author JLS
 * @description:
 * @since 2024-03-27 09:38
 */
public class algorithm_169 {

    public int majorityElement(int[] nums) {
        int sum = 0;
        int temp = 0;
        for (int num :nums) {
            if (num == temp) {
                sum++;
            } else {
                 if (sum == 0) {
                     sum++;
                     temp = num;
                 } else {
                     sum--;
                 }
            }
        }

        return temp;
    }
}
