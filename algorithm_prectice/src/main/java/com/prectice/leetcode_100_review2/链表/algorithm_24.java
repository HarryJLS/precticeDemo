package com.prectice.leetcode_100_review2.链表;

import com.prectice.leetcode.ListNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-29 22:09
 */
public class algorithm_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempNode = new ListNode(1, head);
        ListNode next;
        ListNode temp1;
        ListNode temp2;
        ListNode prev = tempNode;
        while (head != null && head.next != null) {
            next = head.next.next;
            temp1 = head;
            temp2 = head.next;
            prev.next = temp2;
            temp2.next = temp1;
            temp1.next = next;
            prev = prev.next.next;
            head = next;
        }
        return tempNode.next;
    }
}
