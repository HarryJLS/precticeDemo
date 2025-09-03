package com.prectice.leetcode20250826;

/**
 * @author JLS
 * @description: 实现一个函数，给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成
 * @since 2025-08-28 13:25
 */
public class algorithm_459 {

    public boolean repeatedSubstringPattern(String s) {
        String newStr = s + s;
        String strTemp = newStr.substring(1, newStr.length() - 1);
        return strTemp.contains(s);
    }

    public boolean repeatedSubstringPattern2(String s) {

        for (int i = 1; 2 * i <=s.length(); i++) {

            if (s.length() % i == 0) {
                boolean flag = true;
                for (int j = i; j < s.length(); j++) {
                    if (flag && s.charAt(j) == s.charAt(j - i)) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

}
