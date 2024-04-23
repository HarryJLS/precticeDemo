package com.prectice.leetcode_100_review1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2024-04-02 14:48
 */
public class algorithm_560 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            Integer orDefault = map.getOrDefault(sum, 0);
            map.put(sum, orDefault + 1);
        }
        return result;
    }

}
