package com.prectice.leetcode_100_review2.链表2;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-16 17:06
 */
public class algorithm_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA != null ? tempA.next : headB;
            tempB = tempB != null ? tempB.next :headA;
        }
        return tempA;
    }
}
