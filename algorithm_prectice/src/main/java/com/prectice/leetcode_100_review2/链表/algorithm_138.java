package com.prectice.leetcode_100_review2.链表;

import com.prectice.leetcode_100.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-29 23:25
 */
public class algorithm_138 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            nodeMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        Node tempNode = new Node(1);
        tempNode.next = nodeMap.get(head);
        while (head != null) {
            nodeMap.get(head).next = nodeMap.get(head.next);
            nodeMap.get(head).random = nodeMap.get(head.random);
            head = head.next;
        }
        return tempNode.next;
    }
}
