package com.prectice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2023-07-11 11:14
 */
public class algorithm_13 {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);


        int number = 0;
        for (int i = 0; i < s.length(); i++) {

            if (i < s.length() - 1) {
                String temp = s.substring(i, i+1);
                if (map.containsKey(temp)) {
                    number += map.get(temp);
                    i++;

                } else {
                    number += map.get(String.valueOf(s.charAt(i)));
                }
            } else {
                number += map.get(String.valueOf(s.charAt(i)));
            }
        }
        return number;
    }

    public static int romanToInt1(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("a", 4);
        map.put("b", 9);
        map.put("c", 40);
        map.put("d", 90);
        map.put("e", 400);
        map.put("f", 900);
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s=s.replace("XL", "c");
        s=s.replace("XC", "d");
        s=s.replace("CD", "e");
        s=s.replace("CM", "f");

        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            number += map.get(String.valueOf(s.charAt(i)));
        }
        return number;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt1(s));
    }
}
