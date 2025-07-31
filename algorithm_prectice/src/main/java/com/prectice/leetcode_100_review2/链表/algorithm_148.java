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
        
    }
}
