package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-09-19 12:09
 */
public class algorithm_438 {

    public List<Integer> findAnagrams(String s, String p) {
        //用于记录结果
        List<Integer> result = new ArrayList<>();

        int length = p.length();
        int index = 0;
        while (index <= s.length() - length) {
            String substring = s.substring(index, index + length);
            boolean flag = true;
            for (char item : p.toCharArray()) {
                if (!substring.contains(String.valueOf(item))) {
                    flag = false;
                } else {
                    substring = substring.replaceFirst(String.valueOf(item), "-");
                }

            }
            if (flag) {
                result.add(index);
            }
            index++;
        }
        return result;

    }

    /**
     * 也可以利用map做
     * */
    public List<Integer> findAnagrams2(String s, String p) {
        int[] sV = new int[26];
        int[] pV = new int[26];
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> result = new ArrayList<>();
        if (pLength > sLength) {
            return new ArrayList<>();
        }
        for (int i = 0; i < pLength; i++) {
            sV[s.charAt(i) - 'a']++;
            pV[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sV, pV)) {
            result.add(0);
        }
        for (int i = p.length(); i < sLength; i++) {
            sV[s.charAt(i-pLength)-'a']--;
            sV[s.charAt(i) - 'a']++;
            if (Arrays.equals(sV, pV)) {
                result.add(i-pLength+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        algorithm_438 algorithm438 = new algorithm_438();
        System.out.println(algorithm438.findAnagrams2("cbaebabacd", "abc"));
    }
}
