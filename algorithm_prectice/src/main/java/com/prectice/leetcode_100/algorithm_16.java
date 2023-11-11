package com.prectice.leetcode_100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2023-10-25 08:47
 */
public class algorithm_16 {


    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int temp = 0;
        int[] charArr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            temp = Math.max(charArr[index], temp);

            result = Math.max(result, i - temp + 1);

            charArr[index] = i + 1;
        }
        return result;

    }

    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int length = s.length();
        int result = 0;
        while (right < length && left <= right) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                result = Math.max(result, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        algorithm_16 algorithm16 = new algorithm_16();
        int i = algorithm16.lengthOfLongestSubstring("bbbbb");
        System.out.println(i);
    }
}
