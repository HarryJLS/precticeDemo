package com.prectice.tuling_algorithm;

import com.prectice.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2023-08-08 12:45
 */
public class algorithm_141 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if (set.add(head)) {
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode low = head;
        ListNode quick = head.next;
        while (low != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }
            low = low.next;
            quick = quick.next.next;
        }
        return true;
    }
}
