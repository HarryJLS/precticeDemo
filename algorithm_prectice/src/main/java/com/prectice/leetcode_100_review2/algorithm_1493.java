package com.prectice.leetcode_100_review2;

/**
 * @author JLS
 * @description:
 * @since 2025-08-24 14:33
 */
public class algorithm_1493 {
    public int longestSubarray(int[] nums) {
        int second = 0;
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result = Math.max(result, second + sum);
                second = sum;
                sum = 0;
            } else {
                sum++;
            }
        }
        return Math.max(result, sum + second);

    }

    public static void main(String[] args) {
        algorithm_1493 algorithm1493 = new algorithm_1493();
        System.out.println(algorithm1493.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }

}
