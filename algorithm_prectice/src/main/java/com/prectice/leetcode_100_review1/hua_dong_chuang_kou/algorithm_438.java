package com.prectice.leetcode_100_review1.hua_dong_chuang_kou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-05-16 12:46
 */
public class algorithm_438 {

    /**
     * 题解，核心的话，比较字符串是不是异位词，可以通过转数字比较数据的值是否相等来确定是不是异位词
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int[] sSlot = new int[26];
        int[] pSlot = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pSlot[p.charAt(i) - 'a']++;
            sSlot[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sSlot, pSlot)) {
            list.add(0);
        }
        int pLength = p.length();
        for (int i = pLength; i < s.length(); i++) {
            sSlot[s.charAt(i) - 'a']++;
            sSlot[s.charAt(i - pLength) - 'a']--;
            if (Arrays.equals(pSlot, sSlot)) {
                list.add(i - pLength + 1);
            }
        }
        return list;
    }
}
