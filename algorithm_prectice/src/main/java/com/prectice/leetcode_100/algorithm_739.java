package com.prectice.leetcode_100;

import java.util.Stack;

/**
 * @author JLS
 * @description:
 * @since 2023-12-11 13:15
 */
public class algorithm_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;

    }
    public int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        int max = temperatures[length-1];
        int[] result = new int[length];
        result[length-2] = 0;
        for (int i = length-2; i >= 0 ; i--) {
            if (temperatures[i] > max) {
                max = temperatures[i];
            } else {
                if (temperatures[i] == temperatures[i+1]) {
                    if (result[i+1] != 0) {
                        result[i] = result[i+1]+1;
                    }
                    continue;
                }
                for (int j = i+1; j < length; j++) {
                    if (temperatures[j] >temperatures[i]) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = length-2; i >= 0 ; i--) {
            if (temperatures[i] < temperatures[i+1]) {
                result[i] = 1;
            } else {
                int n = i+1;
                while (n < length) {
                    if (temperatures[i] < temperatures[n]) {
                        result[i] = n - i;
                        break;
                    }
                    if (result[n] == 0) {
                        result[i] = 0;
                        break;
                    }
                    n = n + result[n];
                }
            }
        }
        return result;


    }

    public static void main(String[] args) {
        int[] demo = new int[]{30,40,50,60};
        algorithm_739 algorithm739 = new algorithm_739();
        System.out.println(algorithm739.dailyTemperatures1(demo).toString());
    }

}
