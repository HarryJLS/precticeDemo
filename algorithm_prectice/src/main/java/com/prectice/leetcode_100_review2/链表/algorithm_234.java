package com.prectice.leetcode_100_review2.链表;

import com.prectice.leetcode.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-29 20:35
 */
public class algorithm_234 {
    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.addLast(head.val);
            head = head.next;
        }
        while (!list.isEmpty() && list.size() > 1) {
            if (list.getFirst() == list.getLast()) {
                list.removeFirst();
                list.removeLast();
            } else {
                break;
            }
        }
        if (list.isEmpty() || list.size() == 1) {
            return true;
        }
        return false;

    }
}
