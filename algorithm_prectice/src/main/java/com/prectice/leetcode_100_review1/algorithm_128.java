package com.prectice.leetcode_100_review1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2024-04-01 10:32
 */
public class algorithm_128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int temp = num;
                int tempNum = 1;
                while (set.contains(temp+1)) {
                    temp++;
                    tempNum++;
                }
                result = Math.max(result, tempNum);
            }
        }
        return result;
    }
}
