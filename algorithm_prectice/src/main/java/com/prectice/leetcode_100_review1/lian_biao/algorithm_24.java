package com.prectice.leetcode_100_review1.lian_biao;

import com.prectice.leetcode.ListNode;

/**
 * @author JLS
 * @description:
 * @since 2024-05-29 10:53
 */
public class algorithm_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode resultNode = new ListNode(0, head);
        ListNode tempNode = resultNode;
        while (tempNode != null && tempNode.next != null &&tempNode.next.next != null) {
            ListNode next1 = tempNode.next;
            ListNode next2 = tempNode.next.next;
            ListNode temp = next2.next;
            tempNode.next = next2;
            next2.next = next1;
            next1.next = temp;
            tempNode = tempNode.next.next;
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        algorithm_24 algorithm24 = new algorithm_24();
        algorithm24.swapPairs(node);
    }
}
