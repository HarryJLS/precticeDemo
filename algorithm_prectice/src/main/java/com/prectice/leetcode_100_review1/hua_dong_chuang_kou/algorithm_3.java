package com.prectice.leetcode_100_review1.hua_dong_chuang_kou;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2024-05-16 12:31
 */
public class algorithm_3 {

    public int lengthOfLongestSubstring(String s) {

        int maxResult = 0;
        char[] charArray = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for (char c : charArray) {
            if (queue.contains(c)) {
                maxResult = Math.max(maxResult, queue.size());
                do {
                    Character poll = queue.poll();
                    if (poll == c) {
                        break;
                    }
                } while (!queue.isEmpty());
                queue.offer(c);
            } else {
                queue.offer(c);
            }
        }
        maxResult = Math.max(maxResult, queue.size());
        return maxResult;
    }
}
