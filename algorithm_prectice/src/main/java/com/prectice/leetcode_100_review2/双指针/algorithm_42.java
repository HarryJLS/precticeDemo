package com.prectice.leetcode_100_review2.双指针;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-23 20:42
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
        int result = 0;
        int left = 0;
        int size = 0;
        while (left < index) {
            if (height[left] >= size) {
                size = height[left];
            } else {
                result += size - height[left];
            }
            left++;
        }
        int right = height.length - 1;
        size = 0;
        while (index < right) {
            if (height[right] >= size) {
                size = height[right];
            } else {
                result += size - height[right];
            }
            right--;
        }
        return result;
    }
}
