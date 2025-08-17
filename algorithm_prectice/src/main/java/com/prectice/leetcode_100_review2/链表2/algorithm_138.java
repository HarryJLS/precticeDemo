package com.prectice.leetcode_100_review2.链表2;

import com.prectice.leetcode_100.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 14:42
 */
public class algorithm_138 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        Node tempHead = new Node(1);
        Node tempVal = tempHead;
        temp = head;
        while (temp != null) {
            tempVal.next = map.get(temp);
            tempVal.next.random = map.get(temp.random);
            tempVal = tempVal.next;
            temp = temp.next;
        }
        return tempHead.next;
    }
}
