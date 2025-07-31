package com.prectice.leetcode_100_review2.链表;

import com.prectice.leetcode.ListNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-29 21:21
 */
public class algorithm_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int num = 0;
            if (l1 != null && l2 != null) {
                num = l1.val + l2.val + flag;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                num = l1.val + flag;
                l1 = l1.next;
            } else {
                num = l2.val + flag;
                l2 = l2.next;
            }
            head.next = new ListNode(num % 10);
            head = head.next;
            flag = num / 10;
        }
        if (flag > 0) {
            head.next = new ListNode(flag);
        }
        return temp.next;
    }
}
