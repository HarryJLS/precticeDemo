package com.prectice.leetcode_100_review1.zhan;

import java.util.Stack;

/**
 * @author JLS
 * @description:
 * @since 2024-06-17 16:09
 */
public class algorithm_20 {

    public boolean isValid(String s) {

        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (!checkChar(stack, '(')) {
                    return false;
                }
            } else if (c == ']') {
                if (!checkChar(stack, '[')) {
                    return false;
                }
            } else if (c == '}') {
                if (!checkChar(stack, '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    private boolean checkChar(Stack<Character> stack, char target) {
        if (stack.isEmpty()) {
            return false;
        }
        char c = stack.pop();
        if (c == target) {
            return true;
        } else {
            return false;
        }
    }
}
