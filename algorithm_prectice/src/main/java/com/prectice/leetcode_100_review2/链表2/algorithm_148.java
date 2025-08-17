package com.prectice.leetcode_100_review2.链表2;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 14:52
 */
public class algorithm_148 {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempHead = new ListNode(1, head);
        ListNode temp = tempHead;
        ListNode fast = temp;
        ListNode slow = temp;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode headNext = tempHead.next;
        tempHead.next = null;
        ListNode slowNext = slow.next;
        slow.next = null;
        return merge(sort(headNext), sort(slowNext));
    }

    private ListNode merge (ListNode head1, ListNode head2) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null) {
            temp.next = head1;
        }
        if (head2 != null) {
            temp.next = head2;
        }
        return head.next;
    }

}
