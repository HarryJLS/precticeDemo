package com.prectice.leetcode_100_review1.hui_su;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-11 12:21
 */
public class algorithm_22 {

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        reverse(n, n, "");
        return result;


    }

    private void reverse(int left, int right, String temp) {
        if (left == 0 && right == 0) {
            result.add(temp);
        }
        if (left > 0) {
            reverse(left-1, right, temp+"(");
        }
        if (right > left) {
            reverse(left, right-1, temp+")");
        }

    }

}
