package com.prectice.leetcode_100_review2.链表;

import com.prectice.leetcode.ListNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-29 21:36
 */
public class algorithm_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(1, head);
        ListNode prev = temp;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return temp.next;
    }
}
