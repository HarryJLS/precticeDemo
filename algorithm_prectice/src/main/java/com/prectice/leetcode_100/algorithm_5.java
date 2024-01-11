package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2024-01-03 12:25
 */
public class algorithm_5 {

    public String longestPalindrome(String s) {
        int maxLength = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            int tempLength1 = expandCenter(s, i, i);
            if (tempLength1 > maxLength) {
                maxLength = tempLength1;
                left = i;
                right = i;
            }

            int tempLength2 = expandCenter(s, i, i+1);
            if (tempLength2 > maxLength) {
                maxLength = tempLength2;
                left = i;
                right = i + 1;
            }
        }

        if (left == right) {
            return s.substring(left - maxLength/2, right + maxLength/2 + 1);
        } else {
            return s.substring(left - maxLength/2 + 1, right + maxLength/2);
        }

    }

    private int expandCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left + 1 - 2;
    }

    public static void main(String[] args) {
        String s = "12345";
        System.out.println(s.substring(0, 1));
    }
}
