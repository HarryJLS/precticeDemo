package com.prectice.leetcode_100_review2.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-25 15:29
 */
public class algorithm_438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a']++;
            sArray[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArray, pArray)) {
            result.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            sArray[s.charAt(i - p.length()) - 'a']--;
            sArray[s.charAt(i) - 'a']++;
            if (Arrays.equals(sArray, pArray)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
