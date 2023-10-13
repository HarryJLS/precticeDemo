package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2023-09-20 12:07
 */
public class algorithm_560 {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                } else if (sum > k) {
                    break;
                }
            }
        }
        return result;
    }
    public int subarraySum1(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);// 0代表初始没有选择元素的时候，值为1；
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {// 核心思想是大子串减去小子串还是个连续的子串
                result += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;

    }
}
