package com.prectice.leetcode_100_review1.shuang_zhi_zhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-05-15 09:52
 */
public class algorithm_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] +nums[left] +nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                } else if (nums[i] +nums[left] +nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
