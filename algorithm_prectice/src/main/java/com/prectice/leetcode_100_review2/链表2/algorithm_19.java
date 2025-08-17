package com.prectice.leetcode_100_review2.链表2;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 14:23
 */
public class algorithm_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(1, head);
        ListNode slow = temp;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }
}
