package com.prectice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2023-07-26 09:45
 */
public class algorithm_17 {

    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> resultList = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            String temp = map.get(c);
            if (tempList.isEmpty()) {
                for (char c1 : temp.toCharArray()) {
                    tempList.add(String.valueOf(c1));
                }
            } else {
                for (String s : tempList) {
                    for (char c1 : temp.toCharArray()) {
                        resultList.add(s + c1);
                    }
                }
                tempList.clear();
                tempList.addAll(resultList);
                resultList.clear();
            }
        }
        return tempList;

    }

    static List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations1(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // StringBuilder sb = new StringBuilder();
        recursionTest(digits, map, 0);

        return list;

    }

    private void recursionTest(String digits, Map<Character, String> map, int num) {

        // 判断是否到达末尾
        if (num == digits.length()) {
            list.add(sb.toString());
            return;
        }

        // 获取数字对应的字符串
        String str = map.get(digits.charAt(num));
        for (char c : str.toCharArray()) {
            sb.append(c);
            recursionTest(digits, map, num + 1);
            // 去除上面刚加过的字符，避免重复
            sb.deleteCharAt(sb.length() - 1);

        }

    }

}
