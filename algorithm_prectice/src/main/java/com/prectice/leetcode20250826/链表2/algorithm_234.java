package com.prectice.leetcode20250826.链表2;

import com.prectice.leetcode.ListNode;

import java.util.LinkedList;

/**
 * @author JLS
 * @description:
 * @since 2025-08-16 17:25
 */
public class algorithm_234 {

    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (head != null) {
            linkedList.add(head.val);
            head = head.next;
        }
        while (!linkedList.isEmpty() && linkedList.size() >1) {
            if (linkedList.getFirst() != linkedList.getLast()) {
                return false;
            }
            linkedList.removeFirst();
            linkedList.removeLast();
        }
        return true;
    }
}
