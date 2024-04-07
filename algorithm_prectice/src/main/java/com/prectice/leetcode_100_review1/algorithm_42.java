package com.prectice.leetcode_100_review1;

/**
 * @author JLS
 * @description:
 * @since 2024-04-01 11:31
 */
public class algorithm_42 {

    public int trap(int[] height) {
        int result = 0;
        int maxvalue = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxvalue) {
                maxvalue = height[i];
                maxIndex = i;
            }
        }
        int temp = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] > temp) {
                temp = height[i];
            } else {
                result += (temp - height[i]);
            }
        }
        temp = height[height.length - 1];
        for (int i = height.length - 1; i > maxIndex ; i--) {
            if (height[i] > temp) {
                temp = height[i];
            } else {
                result += (temp - height[i]);
            }
        }
        return result;
    }





}
