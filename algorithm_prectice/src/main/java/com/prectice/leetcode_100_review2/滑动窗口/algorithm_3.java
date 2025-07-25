package com.prectice.leetcode_100_review2.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-24 10:31
 */
public class algorithm_3 {

    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int flag = 0;
        for (int i = 0; i < charArray.length; i++) {
            Integer index = map.get(charArray[i]);
            if (index != null) {
                maxLength = Math.max(maxLength, i - flag);
                flag = Math.max(flag, index + 1);
            }
            map.put(charArray[i], i);
        }
        return Math.max(maxLength, charArray.length - flag);
    }

    public static void main(String[] args) {
        algorithm_3 algorithm3 = new algorithm_3();
        System.out.println(algorithm3.lengthOfLongestSubstring("cddc"));
    }
}
