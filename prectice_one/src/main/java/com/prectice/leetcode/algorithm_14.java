package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-11 14:45
 */
public class algorithm_14 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        String s = strs[0];
        for (String str : strs) {
            while (!str.startsWith(s)) {
                if (s.length() == 0) return "";
                s = s.substring(0,s.length());
            }

        }
        return s;
    }
}
