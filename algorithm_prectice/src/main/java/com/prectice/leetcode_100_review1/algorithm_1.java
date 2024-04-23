package com.prectice.leetcode_100_review1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2024-04-01 10:12
 */
public class algorithm_1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (i == map.get(target - nums[i])) {
                    continue;
                }
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }
}
