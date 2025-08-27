package com.prectice.leetcode20250826.动态规划extra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description: 分割回文串
 * @since 2025-08-27 19:53
 */
public class algorithm_131 {

    public List<List<String>> result = new ArrayList<>();

    public List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {

        dfs(s, 0, 1);
        return result;
    }

    private void dfs(String s, int left, int right) {
        if (right > s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = right; i <= s.length(); i++) {
            String strTemp = s.substring(left, i);
            if (isCycle(s, left, i - 1)) {
                temp.add(strTemp);
                dfs(s, i, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean isCycle(String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                startIndex++;
                endIndex--;
            } else {
                return false;
            }
        }
        return true;
    }
}
