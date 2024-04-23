package com.prectice.leetcode_100_review1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2024-04-01 10:20
 */
public class algorithm_49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = Arrays.toString(charArray);
            List<String> orDefault = result.getOrDefault(s, new ArrayList<String>());
            orDefault.add(str);
            result.put(s, orDefault);
        }
        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        algorithm_49 algorithm49 = new algorithm_49();
        algorithm49.groupAnagrams(new String[]{"a", "a"});
    }
}
