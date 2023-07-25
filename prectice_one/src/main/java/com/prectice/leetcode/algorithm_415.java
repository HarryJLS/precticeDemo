package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-17 09:48
 */
public class algorithm_415 {

    public static String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();

        int length = Math.max(length1, length2);
        String number = "";

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        // 进位标识符
        int flag = 0;
        for (int i = 0; i < length; i++) {
            int number1 = 0;
            int number2 = 0;
            if (i < length1) {
                number1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
            }
            if (i < length2) {
                number2 = Integer.parseInt(String.valueOf(num2.charAt(i)));
            }
            number = number + (number1 + number2 + flag)%10;
            flag = (number1 + number2 + flag)/10;
        }
        if (flag != 0) {
            number = number + flag;
        }


        return new StringBuilder(number).reverse().toString();


    }

    public static void main(String[] args) {
        System.out.println(addStrings("9", "99"));
    }



}
