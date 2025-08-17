package com.prectice.leetcode_100_review2.链表2;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 14:14
 */
public class algorithm_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int t1 = 0;
        int t2 = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                t1 = l1.val;
                l1 = l1.next;
            } else {
                t1 = 0;
            }
            if (l2 != null) {
                t2 = l2.val;
                l2 = l2.next;
            } else {
                t2 = 0;
            }
            temp.next = new ListNode((t1 + t2 + flag) % 10);
            temp = temp.next;
            flag = (t1 + t2 + flag)/10;
        }
        if (flag > 0) {
            temp.next = new ListNode(flag);
        }
        return head.next;

    }
}
