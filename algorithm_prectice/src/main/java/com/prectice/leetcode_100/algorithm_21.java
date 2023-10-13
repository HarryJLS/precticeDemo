package com.prectice.leetcode_100;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2023-10-11 13:07
 */
public class algorithm_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultNode = new ListNode(1);
        ListNode tempNode = resultNode;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    tempNode.next = new ListNode(list1.val);
                    tempNode = tempNode.next;
                    list1 = list1.next;
                } else {
                    tempNode.next = new ListNode(list2.val);
                    tempNode = tempNode.next;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                tempNode.next = list1;
                list1 = null;
            } else if (list2 != null) {
                tempNode.next = list2;
                list2 = null;
            }
        }
        return resultNode.next;

    }
}
