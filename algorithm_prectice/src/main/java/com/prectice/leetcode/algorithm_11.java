package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-18 18:44
 */
public class algorithm_11 {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int result = 0;
        while(left <  right) {
            int temp = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(temp, result);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
