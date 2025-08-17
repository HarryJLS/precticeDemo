package com.prectice.leetcode_100_review2.链表2;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 14:37
 */
public class algorithm_24 {

    public ListNode swapPairs(ListNode head) {
        ListNode tempHead = new ListNode(1, head);
        ListNode temp = tempHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode temp1 = temp.next;
            ListNode temp2 = temp.next.next;
            ListNode next = temp.next.next.next;
            temp.next = temp2;
            temp2.next = temp1;
            temp1.next = next;
            temp = temp.next.next;
        }
        return tempHead.next;
    }
}
