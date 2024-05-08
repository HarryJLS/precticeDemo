package com.prectice.leetcode_100_review1.ji_qiao;

/**
 * @author JLS
 * @description: 技巧类
 * @since 2024-05-07 10:00
 */
public class algorithm_169 {

    public int majorityElement(int[] nums) {
        int temp = 0;
        int sum = 0;
        for (int num : nums) {
            if (temp == num) {
                sum++;
            } else {
                if (sum > 0) {
                    sum--;
                } else {
                    temp = num;
                    sum ++;
                }
            }
        }
        return temp;
    }
}
