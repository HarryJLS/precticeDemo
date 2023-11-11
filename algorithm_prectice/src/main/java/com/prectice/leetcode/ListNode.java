package com.prectice.leetcode;

/**
 * @author JLS
 * @description: 链表实体类
 * @since 2023-07-29 17:27
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
