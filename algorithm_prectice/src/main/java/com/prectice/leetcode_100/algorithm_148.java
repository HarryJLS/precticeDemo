package com.prectice.leetcode_100;

import com.prectice.leetcode.ListNode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author JLS
 * @description:
 * @since 2023-10-26 12:22
 */
public class algorithm_148 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        Map<Integer, List<ListNode>> map = new HashMap<>();
        while (head != null) {
            if (map.get(head.val) != null) {
                map.get(head.val).add(head);
            } else {
                map.put(head.val, new ArrayList<>(Arrays.asList(head)));
            }
            head = head.next;
        }
        Set<Integer> integers = map.keySet();
        List<Integer> integerList = new ArrayList<>(integers);

        // 升序排序
        Collections.sort(integerList);
        ListNode node = null;
        for (Integer i : integerList) {
            List<ListNode> listNodes = map.get(i);
            for (int index = 1; index < listNodes.size(); index++) {
                listNodes.get(index-1).next = listNodes.get(index);
            }
            if (node != null) {
                node.next = listNodes.get(0);
            }
            node = listNodes.get(listNodes.size()-1);
            node.next = null;
        }

        return map.get(integerList.get(0)).get(0);
    }

    // 归并算法
    public ListNode sortList1(ListNode head) {
        return head == null ? head : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode quick = head;
        ListNode pre = slow;
        while (quick != null && quick.next != null) {
            pre = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        // 割断前后的链表
        pre.next = null;
        ListNode slowNode = mergeSort(head);
        ListNode quickNode = mergeSort(slow);
        return merge(slowNode, quickNode);
    }
    private ListNode merge(ListNode slowNode, ListNode quickNode) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (slowNode != null && quickNode != null) {
            if (slowNode.val <= quickNode.val) {
                temp.next = slowNode;
                slowNode = slowNode.next;
                temp = temp.next;
                temp.next = null;
            } else {
                temp.next = quickNode;
                quickNode = quickNode.next;
                temp = temp.next;
                temp.next = null;
            }
        }
        if (slowNode == null) {
            temp.next = quickNode;
        }
        if (quickNode == null) {
            temp.next = slowNode;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,  new ListNode(3, new ListNode(1, new ListNode(5, null))));
        algorithm_148 algorithm148 = new algorithm_148();
        System.out.println(algorithm148.sortList1(node));
    }
}
