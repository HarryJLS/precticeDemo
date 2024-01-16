package com.prectice.leetcode_100;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2024-01-15 12:52
 */
public class algorithm_31 {

    public void nextPermutation(int[] nums) {

        int temp = -1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i+1]) {
                temp = i;
            }
        }
        if (temp == -1) {
            Arrays.sort(nums);
        } else {
            Arrays.sort(nums, temp+1, nums.length);
            for (int i = temp+1; i < nums.length; i++) {
                if (nums[i] > nums[temp]) {
                    swap(temp, i, nums);
                    break;
                }
            }
        }

    }

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,2};
        algorithm_31 algorithm31 = new algorithm_31();
        algorithm31.nextPermutation(a);
    }
}
