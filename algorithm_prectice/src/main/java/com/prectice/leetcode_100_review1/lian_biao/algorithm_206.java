package com.prectice.leetcode_100_review1.lian_biao;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2024-05-24 10:40
 */
public class algorithm_206 {

    public ListNode reverseList(ListNode head) {
        // 用于保存原链表的next指针
        ListNode next = null;
        // 用于保存翻转后链表要指向的节点
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
