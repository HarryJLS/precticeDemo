package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-11-27 12:27
 */
public class algorithm_22 {

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return result;
    }

    private void dfs(int left, int right, String temp) {
        if (left == 0 && right == 0) {
            result.add(temp);
            return;
        }
        if (left > 0) {
            dfs(left-1, right, temp + "(");
        }
        if (right > left) {
            dfs(left, right - 1, temp + ")");
        }
    }
}
