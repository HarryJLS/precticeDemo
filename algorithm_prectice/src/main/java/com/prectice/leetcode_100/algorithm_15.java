package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2024-01-31 10:21
 */
public class algorithm_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right && right < nums.length) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    if (nums[left] == nums[right]) {
                        break;
                    }
                    left++;
                    right--;
                    while (left < right) {
                        if (nums[left] == nums[left -1]) {
                            left++;
                        } else {
                            break;
                        }
                    }
                    while (left < right) {
                        if (nums[right] == nums[right + 1]) {
                            right--;
                        } else {
                            break;
                        }
                    }
                } else if (temp > 0) {
                    if (nums[left] == nums[right]) {
                        break;
                    }
                    right--;
                } else {
                    if (nums[left] == nums[right]) {
                        break;
                    }
                    left++;
                }
            }
        }
        return result;
    }
}
