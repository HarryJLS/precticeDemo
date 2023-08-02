package com.prectice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2023-08-02 15:57
 */
public class algorithm_822 {

    public int flipgame(int[] fronts, int[] backs) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                map.put(fronts[i], i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!map.containsKey(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }
            if (!map.containsKey(backs[i])) {
                min = Math.min(min, backs[i]);
            }
        }

        return min == Integer.MAX_VALUE ? 0: min;

    }
}
