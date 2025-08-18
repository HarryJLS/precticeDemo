package com.prectice.leetcode_100_review2.滑动窗口2;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 09:51
 */
public class algorithm_3 {

    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int flag = 0;
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            Integer item = map.get(charArray[i]);
            if (item != null) {
                length = Math.max(length, i - flag);
                flag = Math.max(flag, item + 1);
            }
            map.put(charArray[i], i);
        }
        return Math.max(length, charArray.length - flag);
    }
}
