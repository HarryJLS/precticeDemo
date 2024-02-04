package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2024-01-31 10:13
 */
public class algorithm_11 {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int result = 0;
        while(left < right) {
            if (height[left] < height[right]) {
                result = Math.max(height[left] * (right - left), result);
                left++;
            } else {
                result = Math.max(height[right] * (right - left), result);
                right--;
            }
        }
        return result;
    }
}
