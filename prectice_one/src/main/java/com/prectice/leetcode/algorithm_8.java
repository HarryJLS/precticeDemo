package com.prectice.leetcode;

import org.springframework.util.StringUtils;

/**
 * @author JLS
 * @description: 题目有问题
 * @since 2023-07-17 14:36
 */
public class algorithm_8 {

    public int myAtoi(String s) {

        if ("".equals(s)) {
            return 0;
        }
        if (s.charAt(0) != ' ' && s.charAt(0) != '-' && s.charAt(0) != '+' && !Character.isDigit(s.charAt(0))) {
            return 0;
        }
        String numberStr = "";
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {

            if (String.valueOf(s.charAt(i)).equals("-") || String.valueOf(s.charAt(i)).equals("+") || Character.isDigit(s.charAt(i))) {
                numberStr = getNumber(s, i);
                break;
            }
        }
        long longNumber;
        try {
            longNumber = Long.parseLong(numberStr);
        } catch (Exception e) {
            return 0;
        }
        if ((int) longNumber == longNumber) {
            return (int) longNumber;
        } else {
            if (longNumber > 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

    }

    public String getNumber(String s, Integer index) {
        String  number = "";
        int flag = 0;
        while (index < s.length()) {
            if (flag == 0 && (String.valueOf(s.charAt(index)).equals("-") || String.valueOf(s.charAt(index)).equals("+") || Character.isDigit(s.charAt(index)))) {
                number = number + s.charAt(index++);
                flag = 1;
                continue;
            } else if (flag == 1 && (String.valueOf(s.charAt(index)).equals("-") || String.valueOf(s.charAt(index)).equals("+"))) {
                return "0";
            }else if (flag != 0 && Character.isDigit(s.charAt(index))) {
                number = number + s.charAt(index++);
                if ((Long.parseLong(number) > Integer.MAX_VALUE)) {
                    return number;
                }
                flag = 2;
                continue;
            }
            break;
        }
        return number;
    }

//    public static void main(String[] args) {
//        System.out.println(myAtoi("20000000000000000000"));
//    }


}
