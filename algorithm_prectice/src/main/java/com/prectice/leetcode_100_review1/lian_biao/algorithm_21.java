package com.prectice.leetcode_100_review1.lian_biao;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2024-05-28 10:30
 */
public class algorithm_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultNode = new ListNode(0);
        ListNode head = resultNode;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    resultNode.next = new ListNode(list1.val);
                    resultNode = resultNode.next;
                    list1 = list1.next;
                } else {
                    resultNode.next = new ListNode(list2.val);
                    resultNode = resultNode.next;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                resultNode.next = new ListNode(list1.val);
                resultNode = resultNode.next;
                list1 = list1.next;
            } else if (list2 != null) {
                resultNode.next = new ListNode(list2.val);
                resultNode = resultNode.next;
                list2 = list2.next;
            }
        }
        return head.next;

    }
}
