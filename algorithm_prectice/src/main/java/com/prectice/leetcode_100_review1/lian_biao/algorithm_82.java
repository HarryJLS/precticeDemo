package com.prectice.leetcode_100_review1.lian_biao;

import com.prectice.leetcode.ListNode;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author JLS
 * @description:
 * @since 2024-07-10 19:31
 */
public class algorithm_82 {

    public ListNode deleteDuplicates(ListNode head) {

        int temp = -101;
        ListNode resultHead = new ListNode(2, null);
        ListNode tempNode = resultHead;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                temp = head.val;
            } else if (head.val != head.next.val && temp != head.val) {
                tempNode.next = new ListNode(head.val, null);
                tempNode = tempNode.next;
            }
            head = head.next;
        }
        if (head != null && temp != head.val) {
            tempNode.next = new ListNode(head.val);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.remove(1);
        return resultHead.next;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, null)))));
        algorithm_82 algorithm82 = new algorithm_82();
        algorithm82.deleteDuplicates(node);
    }
}
