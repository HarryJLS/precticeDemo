package com.prectice.leetcode_100_review1.lian_biao;

import com.prectice.leetcode.ListNode;

import java.util.LinkedList;

/**
 * @author JLS
 * @description:
 * @since 2024-05-27 11:25
 */
public class algorithm_234 {

    public boolean isPalindrome(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        while (!list.isEmpty()) {
            try {
                ListNode first = list.getFirst();
                ListNode last = list.getLast();
                if (first != last) {
                    if (first.val != last.val) {
                        return false;
                    }
                }
                list.removeFirst();
                list.removeLast();
            } catch (Exception e) {

            }
        }
        return true;
    }
}
