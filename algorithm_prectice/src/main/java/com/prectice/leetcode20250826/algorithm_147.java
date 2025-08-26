package com.prectice.leetcode20250826;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-23 15:07
 */
public class algorithm_147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(-5000);
        ListNode tail = result;
        if (head == null) {
            return result.next;
        }
        tail.next = head;
        tail = tail.next;
        head = head.next;
        ListNode next;
        while(head != null) {
            if (tail.val <= head.val) {
                tail.next = head;
                tail = tail.next;
                head = head.next;
            } else {
                ListNode prev = result;
                ListNode temp = prev.next;
                while (temp != null) {
                    if (prev.val <= head.val && head.val < temp.val) {
                        next = head.next;
                        prev.next = head;
                        head.next = temp;
                        head = next;
                        break;
                    } else {
                        prev = prev.next;
                        temp = prev.next;
                    }
                }
            }
        }
        tail.next = null;
        return result.next;
    }
}
