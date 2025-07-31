package com.prectice.leetcode_100_review2.链表;

import com.prectice.leetcode.ListNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-29 16:39
 */
public class algorithm_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
