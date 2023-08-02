package com.prectice.tuling_algorithm;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-29 17:29
 */
public class algorithm_206 {
    public ListNode reverseList(ListNode head) {

        // 用于保存上一个节点的数据
        ListNode preNode = null;
        // 用于保存下一本节点的指针
        ListNode nextNode;
        // 用于保存当前所在的节点
        ListNode curNode = head;

        while (curNode != null) {
            // 从头往前进行节点指针反转
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;

            curNode = nextNode;
        }
        return preNode;

    }


    public ListNode reverseList1(ListNode head) {
        // 说明一开始数据为空或者递归到最后一个节点了
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
