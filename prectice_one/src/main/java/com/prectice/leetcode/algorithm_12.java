package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-18 19:13
 */
public class algorithm_12 {
//    public String intToRoman(int num) {
//        String number = "";
//        if (num >= 1000) {
//            number = number + "M".repeat(num / 1000);
//            num = num % 1000;
//            if (num == 0) {
//                return number;
//            }
//        }
//        if (num >= 900) {
//            number += "CM";
//            num -= 900;
//            if (num == 0) {
//                return number;
//            }
//        }
//        if (num >= 500) {
//            number += "D";
//            num -= 500;
//            if (num == 0) {
//                return number;
//            }
//        }
//        if (num >= 400) {
//            number += "CD";
//            num -= 400;
//            if (num == 0) {
//                return number;
//            }
//        }
//        if (num >= 100) {
//            number += "C".repeat(num / 100);
//            num %= 100;
//            if (num == 0) {
//                return number;
//            }
//        }
//        if (num >= 90) {
//            number += "XC";
//            num -= 90;
//            if (num == 0) {
//                return number;
//            }
//        }
//        if (num >= 50) {
//            number +="L";
//            num -= 50;
//            if (num == 0) {
//                return number;
//            }
//        }
//        if (num >= 40) {
//            number += "XL";
//            num -= 40;
//            if (num == 0) {
//                return number;
//            }
//        }
//        if (num >= 10) {
//            number += "X".repeat(num/10);
//            num %= 10;
//            if (num == 0) {
//                return number;
//            }
//        }
//        if (num == 9) {
//            number += "IX";
//            return number;
//        }
//        if (num >= 5) {
//            number += "V";
//            num -= 5;
//            if (num == 0) {
//                return number;
//            }
//        }
//        if (num == 4) {
//            number += "IV";
//            return number;
//        }
//        if (num > 0) {
//            number += "I".repeat(num);
//        }
//        return number;
//
//    }

    public String intToRoman2(int num) {
        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Integer[] integers = new Integer[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0;
        String number = "";
        while (index < strings.length) {
            if (num > integers[index]) {
                number += strings[index];
                num -= integers[index];
            } else if (num == integers[index]) {
                number += strings[index];
                return number;
            } else {
                index++;
            }

        }
        return number;
    }
}
