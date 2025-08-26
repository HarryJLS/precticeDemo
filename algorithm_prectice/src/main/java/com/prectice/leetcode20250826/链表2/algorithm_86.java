package com.prectice.leetcode20250826.链表2;

import com.prectice.leetcode.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-22 16:49
 */
public class algorithm_86 {

    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        ListNode tempHead = new ListNode(0, temp);
        ListNode prev = tempHead;
        while (temp != null) {
            if (temp.val >= x) {
                break;
            }
            temp = temp.next;
            prev = prev.next;
        }
        prev.next = null;
        Queue<ListNode> queue = new LinkedList<>();
        ListNode tempPart = temp;
        ListNode prevPart = new ListNode(0, tempPart);
        while (tempPart != null) {
            if (tempPart.val < x) {
                queue.offer(tempPart);
                tempPart = tempPart.next;
                prevPart.next = tempPart;
            } else {
                tempPart = tempPart.next;
                prevPart = prevPart.next;
            }
        }
        prevPart.next = null;
        while(!queue.isEmpty()) {
            ListNode poll = queue.poll();
            poll.next = null;
            prev.next = poll;
            prev = prev.next;
        }
        prev.next = temp;
        return tempHead.next;
    }

    public static void main(String[] args) {
        algorithm_86 algorithm86 = new algorithm_86();
        ListNode root = new ListNode(2, new ListNode(1));
        algorithm86.partition(root, 2);
    }
}
