package com.prectice.leetcode_100;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2023-10-10 13:25
 */
public class algorithm_206 {

    public ListNode reverseList(ListNode head) {

        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
