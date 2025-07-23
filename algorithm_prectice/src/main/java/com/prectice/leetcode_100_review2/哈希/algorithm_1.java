package com.prectice.leetcode_100_review2.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-22 20:27
 */
public class algorithm_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
