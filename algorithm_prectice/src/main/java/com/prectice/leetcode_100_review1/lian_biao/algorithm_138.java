package com.prectice.leetcode_100_review1.lian_biao;

import com.prectice.leetcode_100.Node;

import java.util.HashMap;

/**
 * @author JLS
 * @description:
 * @since 2024-05-29 11:24
 */
public class algorithm_138 {

    public Node copyRandomList(Node head) {

        Node resultNode = new Node(0);
        HashMap<Node, Node> nodeMap  = new HashMap<>();
        Node tempNode = head;
        while (tempNode != null) {
            nodeMap.put(tempNode, new Node(tempNode.val));
            tempNode = tempNode.next;
        }
        resultNode.next = nodeMap.get(head);
        while (head != null) {
            nodeMap.get(head).next = nodeMap.get(head.next);
            nodeMap.get(head).random = nodeMap.get(head.random);
            head = head.next;
        }
        return resultNode.next;

    }
}
