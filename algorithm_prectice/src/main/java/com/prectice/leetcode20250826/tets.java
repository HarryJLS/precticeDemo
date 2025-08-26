package com.prectice.leetcode20250826;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-19 17:39
 */
public class tets {
    public static String findMax(List<String> list) {

        String result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = max(result, list.get(i));
        }
        return result;
    }

    public static String max(String num1, String num2) {
        String[] array1 = num1.split("\\.");
        String[] array2 = num2.split("\\.");
        int index = 0;
        while (index < array1.length || index < array2.length) {
            if (index >= array1.length && index >= array2.length) {
                return num1;
            } else if (index >= array2.length) {
                return num1;
            } else if (index >= array1.length) {
                return num2;
            }
            if (Integer.valueOf(array1[index]) > Integer.valueOf(array2[index])) {
                return num1;
            } else if (Integer.valueOf(array1[index]) < Integer.valueOf(array2[index])) {
                return num2;
            }
            index++;
        }
        return num1;
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList("10.2.1", "10.2", "11.6", "12.0");
        System.out.println(findMax(list));

    }
}
