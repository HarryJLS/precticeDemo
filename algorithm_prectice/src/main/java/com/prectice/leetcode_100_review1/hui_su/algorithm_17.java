package com.prectice.leetcode_100_review1.hui_su;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-07 10:28
 */
public class algorithm_17 {

    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        reverse(digits, map, 0);
        return result;
    }

    private void reverse(String digits, HashMap<String, String> map, int index) {
        if (index >= digits.length()) {
            result.add(sb.toString());
            return;
        }
        String s = map.get(String.valueOf(digits.charAt(index)));
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            reverse(digits, map, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }


    }
}
