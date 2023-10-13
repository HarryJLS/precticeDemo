package com.prectice.leetcode_100;

import com.prectice.leetcode.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2023-10-11 12:41
 */
public class algorithm_142 {

    public ListNode detectCycle(ListNode head) {

        ListNode curr = head;
        List<ListNode> tempList = new ArrayList<>();
        while(curr != null) {
            if (tempList.contains(curr)) {
                return curr;
            } else {
                tempList.add(curr);
                curr = curr.next;
            }
        }
        return null;

    }
    public ListNode detectCycle1(ListNode head) {
        ListNode curr = head;
        Set<ListNode> set = new HashSet<>();
        while (curr != null) {
            boolean add = set.add(curr);
            if (!add) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }


}
