package com.prectice.leetcode_100;

import java.util.HashMap;

/**
 * @author JLS
 * @description:
 * @since 2024-01-31 10:03
 */
public class algorithm_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[]{};
    }

}
