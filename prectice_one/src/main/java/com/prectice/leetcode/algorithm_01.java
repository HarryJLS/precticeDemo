package com.prectice.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author JLS
 * @description:
 * @since 2023-07-03 20:24
 */
public class algorithm_01 {

    public int[] twoSum1(int[] nums, int target) {

        int number = nums.length;
        for (int i = 0; i < number - 1; i++) {
            for (int j = i + 1; j < number; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];
            if (!map.containsKey(number)) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, map.get(number)};
            }
        }

        return new int[]{};
    }
}
