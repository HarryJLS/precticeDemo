package com.prectice.leetcode_100_review1.lian_biao;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2024-05-28 11:16
 */
public class algorithm_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        ListNode prev = temp;
        ListNode curData = temp.next;
        for (int i = 0; i < n; i++) {
            curData = curData.next;
        }
        while (curData != null) {
            curData = curData.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return temp.next;
    }
}
