package com.prectice.leetcode_100_review1.ha_xi;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2024-05-13 11:38
 */
public class algorithm_128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int max = 0;
        int temp = 1;
        while (right < nums.length) {
            if (nums[right] == nums[left] + temp) {
                temp++;
                right++;
            } else if (nums[right] < nums[left] + temp){
                right++;
            } else {
                max = Math.max(temp, max);
                temp = 1;
                left = right;
                right++;
            }
        }
        max = Math.max(temp, max);
        return max;
    }

    public static void main(String[] args) {
        algorithm_128 algorithm128 = new algorithm_128();
        int[] nums = new int[]{100, 4, 200, 1, 2, 3};
        algorithm128.longestConsecutive(nums);
    }
}
