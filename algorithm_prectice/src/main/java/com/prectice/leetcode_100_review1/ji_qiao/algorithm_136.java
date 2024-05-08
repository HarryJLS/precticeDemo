package com.prectice.leetcode_100_review1.ji_qiao;

import java.util.HashMap;
import java.util.Set;

/**
 * @author JLS
 * @description: 技巧类
 * @since 2024-05-07 09:49
 */
public class algorithm_136 {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> integers = map.keySet();
        Integer next = integers.iterator().next();
        return next;

    }

    public int singleNumber1(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp = temp ^ num;
        }
        return temp;

    }
}
