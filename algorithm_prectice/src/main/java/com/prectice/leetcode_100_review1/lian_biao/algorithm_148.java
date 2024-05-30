package com.prectice.leetcode_100_review1.lian_biao;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2024-05-30 11:24
 */
public class algorithm_148 {

    public ListNode sortList(ListNode head) {
        return head == null ? head : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode merge1 = mergeSort(head);
        ListNode merge2 = mergeSort(slow);

        return merge(merge1, merge2);
    }

    private ListNode merge(ListNode merge1, ListNode merge2) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (merge1 != null || merge2 != null) {
            if (merge1 != null && merge2 != null) {
                if (merge1.val < merge2.val) {
                    node.next = merge1;
                    merge1 = merge1.next;
                    node = node.next;
                } else {
                    node.next = merge2;
                    merge2 = merge2.next;
                    node = node.next;
                }
            } else if (merge1 != null) {
                node.next = merge1;
                break;
            } else {
                node.next = merge2;
                break;
            }
        }
        return temp.next;
    }
}
