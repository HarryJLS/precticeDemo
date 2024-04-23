package com.prectice.leetcode_100_review1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2024-04-02 14:21
 */
public class algorithm_3 {

    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        char[] charArray = s.toCharArray();
        int max = 0;
        for (char c : charArray) {
            if (queue.contains(c)) {
                max = Math.max(max, queue.size());
                Character poll = queue.poll();
                while (!poll.equals(c)) {
                    poll = queue.poll();
                }
                queue.offer(c);
            } else {
                queue.offer(c);
            }
        }
        max = Math.max(max, queue.size());
        return max;
    }

    public static void main(String[] args) {
        algorithm_3 algorithm3 = new algorithm_3();
        System.out.println(algorithm3.lengthOfLongestSubstring("aaa"));
    }
}
