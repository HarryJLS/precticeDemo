package com.prectice.leetcode_100_review1.shuang_zhi_zhen;

/**
 * @author JLS
 * @description:
 * @since 2024-05-14 10:42
 */
public class algorithm_11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, (right-left) * height[left]);
                left++;
            } else{
                max = Math.max(max, (right-left) * height[right]);
                right--;
            }
        }
        return max;
    }
}
