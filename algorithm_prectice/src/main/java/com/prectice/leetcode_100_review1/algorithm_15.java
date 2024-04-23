package com.prectice.leetcode_100_review1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-04-01 11:17
 */
public class algorithm_15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (left > i+1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (nums[i] + nums[left] + nums[right] == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else{
                    left++;
                }

            }
        }
        return result;

    }
}
