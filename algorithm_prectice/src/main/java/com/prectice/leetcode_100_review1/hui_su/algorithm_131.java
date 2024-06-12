package com.prectice.leetcode_100_review1.hui_su;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-12 11:29
 */
public class algorithm_131 {


    LinkedList<String> temp = new LinkedList<>();
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {

        reverse(s, 0, 1);
        return result;


    }
    private void reverse(String s, int startIndex, int endIndex) {
        if (endIndex > s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = endIndex; i <= s.length(); i++) {
            String tempStr = s.substring(startIndex, i);
            if (isCycle(s, startIndex, i-1)) {
                temp.addLast(tempStr);
                reverse(s, i, i+1);
                temp.removeLast();
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
