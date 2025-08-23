package com.prectice.leetcode_100_review2.链表2;

import com.prectice.leetcode.ListNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-22 17:33
 */
public class algorithm_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode tempHead = new ListNode(0, head);
        ListNode tempLeft = tempHead;
        for (int i = 0; i < left-1; i++) {
            tempLeft = tempLeft.next;
        }
        ListNode tempRight = new ListNode(0, head);
        for (int i = 0; i < right; i++) {
            tempRight = tempRight.next;
        }
        ListNode leftHead = tempLeft.next;
        tempLeft.next = null;
        ListNode rightHead = tempRight.next;
        tempRight.next = null;

        ListNode prev = null;
        ListNode next = null;
        ListNode temp = leftHead;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        tempLeft.next = prev;
        leftHead.next = rightHead;
        return tempHead.next;
    }
}
