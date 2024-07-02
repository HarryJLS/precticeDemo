package com.prectice.leetcode_100_review1.dong_tai_gui_hua;

/**
 * @author JLS
 * @description:
 * @since 2024-06-28 10:35
 */
public class algorithm_152 {


    public int maxProduct(int[] nums) {
        int maxTemp = 1;
        int minTemp = 1;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = maxTemp;
                maxTemp = minTemp;
                minTemp = temp;
            }
            maxTemp = Math.max(num, maxTemp*num);
            minTemp = Math.min(num, minTemp*num);
            result = Math.max(result, maxTemp);
        }

        return result;

    }
}
