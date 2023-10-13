package com.prectice.leetcode_100;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2023-10-10 12:35
 */
public class algorithm_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;


    }

}
