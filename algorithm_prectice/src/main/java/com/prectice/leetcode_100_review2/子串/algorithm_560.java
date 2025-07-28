package com.prectice.leetcode_100_review2.子串;

import java.util.*;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-25 16:53
 */
public class algorithm_560 {

    public int subarraySum(int[] nums, int k) {
        int[] temp = new int[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(0)));
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            temp[i] = sum;
            if (map.containsKey(temp[i] - k)) {
                result += map.get(temp[i] - k).size();
            }
            map.computeIfAbsent(temp[i], t -> new ArrayList<>()).add(i);
        }
        return result;
    }


    public static void main(String[] args) {
        algorithm_560 algorithm560 = new algorithm_560();
        System.out.println(algorithm560.subarraySum(new int[]{1,-1,0}, 0));
    }
}
