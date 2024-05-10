package com.prectice.leetcode_100_review1.duo_wei_dong_tai_gui_hua;

/**
 * @author JLS
 * @description:
 * @since 2024-05-10 10:35
 */
public class algorithm_5 {

    public String longestPalindrome(String s) {

        int tempLength = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            int tempSame = expandStr(s, i, i);
            if (tempSame > tempLength) {
                tempLength = tempSame;
                left = i;
                right = i;
            }

            if (i < s.length() - 1) {
                int tempDiff = expandStr(s, i, i+1);
                if (tempDiff > tempLength) {
                    tempLength = tempDiff;
                    left = i;
                    right = i+1;
                }
            }
        }
        if (left == right) {
            return s.substring(left - tempLength / 2, right + tempLength / 2 + 1);
        } else {
            return s.substring(left - tempLength / 2 + 1, right+ tempLength / 2);
        }


    }

    private int expandStr(String s, int left, int right) {

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return right - left - 1;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }
}
