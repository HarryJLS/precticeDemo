package com.prectice.leetcode_100_review2.链表;

import com.prectice.leetcode.ListNode;

import java.util.*;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-30 10:04
 */
public class algorithm_148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        Map<Integer, List<ListNode>> nodeMap = new HashMap<>();
        while (temp != null) {
            nodeMap.computeIfAbsent(temp.val, t -> new ArrayList<>()).add(temp);
            temp = temp.next;
        }
        Set<Integer> integers = nodeMap.keySet();
        Object[] array = integers.toArray();
        Arrays.sort(array);
        ListNode tempHead = new ListNode(1);
        ListNode copyHead = tempHead;
        for (int i = 0; i < array.length; i++) {
            List<ListNode> listNodes = nodeMap.get((Integer) array[i]);
            for (ListNode listNode : listNodes) {
                copyHead.next = listNode;
                copyHead = copyHead.next;
            }
        }
        copyHead.next = null;
        return tempHead.next;
    }

    public ListNode sortList1(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        ListNode prev = slow;
        while (quick != null && quick.next != null) {
            prev = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        prev.next = null;
        ListNode headNode = mergeSort(head);
        ListNode slowNode = mergeSort(slow);

        return merge(headNode, slowNode);
    }
    private ListNode merge(ListNode head, ListNode slow) {
        ListNode result = new ListNode(1);
        ListNode temp = result;

        while (head != null && slow != null) {
            if (head.val <= slow.val) {
                temp.next = head;
                head = head.next;
            } else {
                temp.next = slow;
                slow = slow.next;
            }
            temp = temp.next;
        }
        if (head != null) {
            temp.next = head;
        }
        if (slow != null) {
            temp.next = slow;
        }
        return result.next;
    }
}
