package com.prectice.leetcode_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2024-01-10 12:14
 */
public class algorithm_136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.remove(num);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            return entry.getKey();
        }
        return 0;
    }

    public int singleNumver1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(3^2);
    }
}
