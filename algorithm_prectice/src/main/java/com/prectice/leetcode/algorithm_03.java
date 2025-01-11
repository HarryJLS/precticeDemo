package com.prectice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2023-07-04 19:32
 */
public class algorithm_03 {

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (right < s.length()) {

            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, set.size());
        }

        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                result = Math.max(result, right - left);
                left = Math.max(map.get(s.charAt(i)), left);
            }
            right = i;
            map.put(s.charAt(i), i);
        }
        return Math.max(result, right - left);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bjdsjbfgj"));
    }


}
