package com.prectice.leetcode_100;

import com.prectice.leetcode.ListNode;

import java.util.LinkedList;

/**
 * @author JLS
 * @description:
 * @since 2023-10-10 12:50
 */
public class algorithm_234 {

    public boolean isPalindrome(ListNode head) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        while (head != null) {
            linkedList.addFirst(head.val);
            head = head.next;
        }
        while (!linkedList.isEmpty()) {
            try {
                int left = linkedList.removeFirst();
                int right = linkedList.removeLast();
                if (left != right) {
                    return false;
                }
            } catch (Exception e) {
                return true;
            }

        }
        return true;

    }

    public static void main(String[] args) {

    }
}
