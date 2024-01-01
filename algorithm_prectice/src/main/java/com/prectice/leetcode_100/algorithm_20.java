package com.prectice.leetcode_100;

import java.util.Stack;

/**
 * @author JLS
 * @description:
 * @since 2023-12-07 12:09
 */
public class algorithm_20 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (!checkChar(stack, '(')) {
                    return false;
                }

            } else if (c == '}') {
                if (!checkChar(stack, '{')) {
                    return false;
                }
            } else if (c == ']') {
                if (!checkChar(stack, '[')) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkChar(Stack<Character> stack, char target) {
        if (stack.isEmpty()) {
            return false;
        }
        char pop = stack.pop();
        if (pop != target) {
            return false;
        }
        return true;
    }
}
