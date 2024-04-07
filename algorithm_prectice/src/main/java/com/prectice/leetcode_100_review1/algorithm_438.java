package com.prectice.leetcode_100_review1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-04-02 14:39
 */
public class algorithm_438 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int[] sv = new int[26];
        int[] pv = new int[26];
        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength) {
            return result;
        }
        for (int i = 0; i < pLength; i++) {
            sv[s.charAt(i) - 'a']++;
            pv[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sv, pv)) {
            result.add(0);
        }
        for (int i = pLength; i < s.length(); i++) {
            sv[s.charAt(i - pLength) - 'a']--;
            sv[s.charAt(i) - 'a']++;
            if (Arrays.equals(sv, pv)) {
                result.add(i-pLength+1);
            }
        }
        return result;

    }
}
