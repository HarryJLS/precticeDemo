package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-06 19:26
 */
public class algorithm_09 {

    public static boolean isPalindrome(int x) {

        String number = String.valueOf(x);
        int left = 0;
        int right = number.length() - 1;
        while (right > left + 1) {
            if (number.charAt(left) == number.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }
        if (number.charAt(left) == number.charAt(right)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome2(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

            int cov = 0;
            while (x > cov) {
                cov = cov * 10 + x % 10;
                x = x / 10;
            }
            return x == cov || x == cov / 10;


    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(123454321));
    }
}
