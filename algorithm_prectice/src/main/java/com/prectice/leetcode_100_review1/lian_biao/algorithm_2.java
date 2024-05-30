package com.prectice.leetcode_100_review1.lian_biao;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2024-05-28 10:39
 */
public class algorithm_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode head = resultNode;
        // 标志是否有进位
        int flag = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int value = l1.val + l2.val + flag;
                flag = value / 10;
                resultNode.next = new ListNode(value % 10);
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                int value = l1.val + flag;
                flag = value / 10;
                resultNode.next = new ListNode(value % 10);
                l1 = l1.next;
            } else if (l2 != null) {
                int value = l2.val + flag;
                flag = value / 10;
                resultNode.next = new ListNode(value % 10);
                l2 = l2.next;
            }
            resultNode = resultNode.next;
        }
        if (flag >0) {
            resultNode.next = new ListNode(flag);
        }
        return head.next;
    }
}
