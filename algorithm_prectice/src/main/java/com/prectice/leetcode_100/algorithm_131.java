package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-11-28 12:39
 */
public class algorithm_131 {

    private LinkedList<String> temp = new LinkedList<>();
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {

        dfs(s, 0, 1);
        return result;

    }

    private void dfs(String s, int startIndex, int endIndex) {
        if (endIndex > s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = endIndex; i < s.length() + 1; i++) {
            String tempStr = s.substring(startIndex, i);
            if (isCycle(s, startIndex, i-1)) {
                temp.addLast(tempStr);
                dfs(s, i, i+1);
                temp.removeLast();
            }
        }
    }


    // 判断是否为回文字符串
    private boolean isCycle(String s, int startIndex, int endIndex) {
         while (endIndex > startIndex) {
             if (s.charAt(startIndex) == s.charAt(endIndex)) {
                 startIndex++;
                 endIndex--;
             } else {
                 return false;
             }
         }
         return true;
    }

    public static void main(String[] args) {
        algorithm_131 algorithm131 = new algorithm_131();
        System.out.println(algorithm131.partition("cbbbcc").toString());
    }
}
