package com.prectice.leetcode_100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2024-02-04 16:25
 */
public class algorithm_3 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        while (left <= right && right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right++);
                result = Math.max(result, right - left);
            } else {
                left = map.get(s.charAt(right)) + 1 > left ? map.get(s.charAt(right)) + 1 : left;
                result = Math.max(result, right - left);
                map.put(s.charAt(right), right++);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        algorithm_3 algorithm3 = new algorithm_3();
        algorithm3.lengthOfLongestSubstring("pwwkew");
    }
}
