package com.prectice.leetcode_100_review1.tan_xin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-21 11:09
 */
public class algorithm_763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, map.get(s.charAt(i)));
            if (right == i) {
                result.add(right - left);
                left = i+1;
            }
        }
        return result;

    }
}
