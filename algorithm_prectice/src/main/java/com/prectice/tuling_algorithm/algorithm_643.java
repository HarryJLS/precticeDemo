package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-09 12:38
 */
public class algorithm_643 {

    public double findMaxAverage(int[] nums, int k) {

        int left = 0;
        int right = k-1;
        int sum = 0;
        int result = 0;
        for (int i=0; i < k; i++) {
            sum += nums[i];
        }
        result = sum;

        while (right < nums.length-1) {
            sum += nums[++right];
            sum -= nums[left++];
            result = Math.max(sum, result);
        }

        return (double) result / k;
    }

    public double findMaxAverage1(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;
        int result = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result = sum;
        for (int i = k; i < length; i++) {
            sum += nums[i];
            sum -= nums[i-k];
            result = Math.max(sum, result);
        }
        return (double) result / k;
    }
}
