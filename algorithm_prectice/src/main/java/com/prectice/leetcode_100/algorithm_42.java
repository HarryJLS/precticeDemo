package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-09-18 12:18
 */
public class algorithm_42 {

    public int trap(int[] height) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                index = i;
            }
        }
        // 计算左边的雨水
        int temp = 0;
        int result = 0;
        for (int i = 0; i < index; i++) {
            if (height[i] > temp) {
                temp = height[i];
            } else if(height[i] < temp) {
                result += temp-height[i];
            }
        }
        temp = 0;
        for (int i = height.length - 1; i > index; i--) {
            if (height[i] > temp) {
                temp = height[i];
            } else if(height[i] < temp) {
                result += temp-height[i];
            }
        }
        return result;
    }
}
