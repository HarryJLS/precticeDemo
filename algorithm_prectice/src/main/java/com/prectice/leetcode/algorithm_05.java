package com.prectice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2023-07-07 15:16
 */
public class algorithm_05 {
    public static String longestPalindrome(String s) {

        int length = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int max = 0;
            // 奇数子串
            Integer center = center(s, i, i);
            length = Math.max(length, center);
            max = Math.max(max, center);
            // 偶数子串
            Integer center1 = center(s, i, i + 1);
            length = Math.max(length, center1);
            max = Math.max(max, center1);

            map.put(max, i);
        }
        Integer number = map.get(length);
        if (length == 1) {
            return String.valueOf(s.charAt(number));
        } else {
            if (length % 2 == 1) {
                return s.substring(number - length / 2, number + length / 2 + 1);
            } else {
                return s.substring(number - length / 2 + 1, number + length / 2 + 1);
            }
        }

    }

    /**
     * 中间扩散
     */
    public static Integer center(String s, Integer left, Integer right) {

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        if ((right - left) % 2 == 0) {
            return right - left + 1 - 2;
        } else {
            if (right - left == 1) {
                return 1;
            } else {
                return right - left + 1 - 2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

}
