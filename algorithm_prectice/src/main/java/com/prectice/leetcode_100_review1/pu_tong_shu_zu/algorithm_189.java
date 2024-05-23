package com.prectice.leetcode_100_review1.pu_tong_shu_zu;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2024-05-21 09:49
 */
public class algorithm_189 {
    public void rotate(int[] nums, int k) {
        // k取余，避免不必要的遍历
        k %= nums.length;
        if (k == 0) {
            return;
        }
        int[] temp = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        int index = nums.length - 1 - k;
        while (index >= 0) {
            nums[index + k] = nums[index];
            index--;
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

}
