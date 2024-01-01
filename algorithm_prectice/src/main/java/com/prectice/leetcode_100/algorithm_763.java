package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-12-19 12:29
 */
public class algorithm_763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> resultList = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, map.get(s.charAt(i)));
            if (i == right) {
                resultList.add(right - left + 1);
                left = i+1;
            }
        }
        return resultList;
    }
}
