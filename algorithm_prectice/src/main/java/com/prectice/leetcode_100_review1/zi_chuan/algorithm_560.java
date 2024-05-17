package com.prectice.leetcode_100_review1.zi_chuan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2024-05-17 09:29
 */
public class algorithm_560 {

    // 只适合全为正数的数组
    public int subarraySum(int[] nums, int k) {

        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            queue.offer(num);
            sum += num;
            if (sum < k) {
                continue;
            } else if (sum == k) {
                result ++;
                Integer poll = queue.poll();
                sum -= poll;
            } else {
                while (sum > k && !queue.isEmpty()) {
                    Integer poll = queue.poll();
                    sum -= poll;
                }
                if (sum == k && !queue.isEmpty()) {
                    result++;
                    Integer poll = queue.poll();
                    sum -= poll;
                }
            }
        }
        return result;
    }

    public int subarraySum1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            Integer defaultValue = map.getOrDefault(sum, 0);
            map.put(sum, defaultValue+1);
        }
        return result;
    }


}
