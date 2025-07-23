package com.prectice.leetcode_100_review2.哈希;

import java.util.*;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-22 20:41
 */
public class algorithm_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String temp = Arrays.toString(charArray);
            resultMap.computeIfAbsent(temp, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(resultMap.values());
    }

    public static void main(String[] args) {
        algorithm_49 algorithm49 = new algorithm_49();
        List<List<String>> lists = algorithm49.groupAnagrams(new String[]{"a"});
    }
}
