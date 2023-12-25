package com.prectice.leetcode_100;

import java.util.Stack;

/**
 * @author JLS
 * @description:
 * @since 2023-12-11 12:30
 */
public class algorithm_394 {
    public String decodeString(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        int flagStr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a' && stack.isEmpty()) {
                stringBuilder.append(s.charAt(i));
            } else {
                if (s.charAt(i) != ']') {
                    stack.push(s.charAt(i));
                    if (s.charAt(i) == '[') {
                        flagStr++;
                    }
                } else {
                    StringBuilder tempSb = new StringBuilder();
                    StringBuilder tempResult = new StringBuilder();
                    Stack<Character> stack1 = new Stack<>();
                    while (stack.peek() != '[') {
                        stack1.push(stack.pop());
                    }
                    while (!stack1.isEmpty()) {
                        tempSb.append(stack1.pop());
                    }
                    stack.pop();
                    flagStr--;
                    int number = 0;
                    int flag = 1;
                    while (!stack.isEmpty()) {
                        if (stack.peek() <= '9' && stack.peek() >= '0') {
                            char c = stack.pop();
                            number += Integer.valueOf(String.valueOf(c)) * flag;
                            flag *= 10;
                        } else {
                            break;
                        }
                    }
                    for (int j = 0; j < number; j++) {
                        tempResult.append(tempSb);
                    }
                    if (flagStr == 0) {
                        stringBuilder.append(tempResult);
                    } else {
                        String string = tempResult.toString();
                        for (int j = 0; j < string.length(); j++) {
                            stack.push(string.charAt(j));
                        }
                    }
                }
            }
        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        algorithm_394 algorithm394 = new algorithm_394();
        System.out.println(algorithm394.decodeString("3[a]2[bc]"));
    }

}
