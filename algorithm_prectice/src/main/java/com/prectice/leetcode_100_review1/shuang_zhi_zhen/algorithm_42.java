package com.prectice.leetcode_100_review1.shuang_zhi_zhen;

/**
 * @author JLS
 * @description:
 * @since 2024-05-15 10:22
 */
public class algorithm_42 {

    public int trap(int[] height) {
        int maxIndex = 0;
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        int result = 0;
        int left = 0;
        int temp = 0;
        while (left < maxIndex) {
            if (height[left] > temp) {
                temp = height[left];
                left++;
            } else {
                result += temp - height[left];
                left++;
            }
        }
        int right = height.length - 1;
        temp = 0;
        while (right > maxIndex) {
            if (height[right] > temp) {
                temp = height[right];
            } else {
                result += temp - height[right];
                right--;
            }
        }
        return result;
    }
}
