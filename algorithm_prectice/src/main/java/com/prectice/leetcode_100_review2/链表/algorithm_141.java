package com.prectice.leetcode_100_review2.链表;

import com.prectice.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-29 20:57
 */
public class algorithm_141 {

    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                return true;
            }
            list.add(head);
            head = head.next;
        }
        return false;
    }
}
