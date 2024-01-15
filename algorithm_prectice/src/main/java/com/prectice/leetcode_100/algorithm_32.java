package com.prectice.leetcode_100;

import org.springframework.util.StringUtils;

import java.util.Stack;

/**
 * @author JLS
 * @description:
 * @since 2023-12-25 12:55
 */
public class algorithm_32 {

    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    dp[i] = 1;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            dp[stack.pop()] = 1;
        }
        int result = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (dp[right] == 1) {
                result = Math.max(right-left, result);
                right++;
                left = right;
            } else {
                right++;
            }
        }
        if (left < s.length()) {
            result = Math.max(result, right-left);
        }
        return result;
    }


    public int longestValidParentheses1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            int j = dp[i-1] == 0 ? i-1 : i-1-dp[i-1];
            if (j >= 0 && s.charAt(i) == '(') {
                dp[i] = dp[i - 1] + 2;
                dp[j] = dp[i];
                if (j - 1 >= 0 && dp[j - 1] > 0) {
                    dp[i] += dp[j - 1];
                    dp[j] = dp[i];
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}
