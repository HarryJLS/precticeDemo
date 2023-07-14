package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-13 16:34
 */
public class algorithm_6 {

    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() < numRows) {
            return s;
        }
        char[] arr = new char[s.length()];
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            int k = 2 * i;
            for (int j = i; j < s.length();) {

                if (k != 0 || j ==0) {
                    arr[index] = s.charAt(j);
                    index++;
                }
                k = (2*numRows-2)-k;
                j+=k;
            }
        }
        return new String(arr);
    }
}
