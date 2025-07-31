package com.prectice.leetcode_100_review2.链表;

import com.prectice.leetcode.ListNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-29 21:12
 */
public class algorithm_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeNode = new ListNode(1);
        ListNode temp = mergeNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                mergeNode.next = list1;
                list1 = list1.next;
            } else {
                mergeNode.next = list2;
                list2 = list2.next;
            }
            mergeNode = mergeNode.next;
        }
        if (list1 != null) {
            mergeNode.next = list1;
        }
        if (list2 != null) {
            mergeNode.next = list2;
        }
        return temp.next;
    }
}
