package com.prectice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2023-07-28 10:14
 */
public class algorithm_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>(new ArrayList<>());
        }
        List<String> strList = new ArrayList<>();
        // 用于存放字符串列表数据map
        Map<String, List<String>> strGroup = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newStr = new String(charArray);
            List<String> list = strGroup.getOrDefault(newStr, new ArrayList<>());
            list.add(str);
            strGroup.put(newStr, list);
        }
        return new ArrayList<>(strGroup.values());
    }
}
