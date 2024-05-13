package com.prectice.leetcode_100_review1.ha_xi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2024-05-13 11:30
 */
public class algorithm_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String tempStr = Arrays.toString(charArray);
            List<String> list = map.getOrDefault(tempStr, new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

}
