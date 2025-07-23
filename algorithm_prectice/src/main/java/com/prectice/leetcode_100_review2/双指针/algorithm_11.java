package com.prectice.leetcode_100_review2.双指针;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-23 20:14
 */
public class algorithm_11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right =  height.length - 1;
        int result = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(area, result);
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
