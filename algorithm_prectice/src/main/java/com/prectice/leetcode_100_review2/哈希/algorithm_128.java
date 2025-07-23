package com.prectice.leetcode_100_review2.哈希;

import java.util.Arrays;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-22 20:59
 */
public class algorithm_128 {

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 1) {
            return nums.length;
        }
        int left = 0;
        int right = 1;
        int result = 1;
        while (left < right && right < nums.length) {
            if (nums[right] == nums[right-1] + 1) {
                right++;
            } else if (nums[right] == nums[right - 1]) {
                right++;
                left++;
            }else {
                result = Math.max(right - left, result);
                left = right++;
            }
        }
        return Math.max(right - left, result);
    }

    public static void main(String[] args) {
        algorithm_128 algorithm128 = new algorithm_128();
        int i = algorithm128.longestConsecutive(new int[]{1, 2, 4});
        System.out.println(i);
    }
}
