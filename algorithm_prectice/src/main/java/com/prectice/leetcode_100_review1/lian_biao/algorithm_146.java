package com.prectice.leetcode_100_review1.lian_biao;

import java.util.HashMap;

/**
 * @author JLS
 * @description:
 * @since 2024-05-30 16:45
 */
public class algorithm_146 {

    public final HashMap<Integer, Node> nodeMap = new HashMap<>();

    Node head;
    Node tail;
    Integer cap;
    Integer size = 0;

    class Node {
        int val;
        int key;
        Node next;
        Node prev;
    }

    algorithm_146(Integer cap) {
        this.cap = cap;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public Integer get(Integer key) {
        if (nodeMap.get(key) == null) {
            return -1;
        }
        mergeTwoNode(nodeMap.get(key).prev, nodeMap.get(key).next);
        mergeTwoNode(tail.prev, nodeMap.get(key));
        mergeTwoNode(nodeMap.get(key), tail);
        return nodeMap.get(key).val;
    }

    public void put(Integer key, Integer val) {
        if (nodeMap.get(key) != null) {
            Node prev = nodeMap.get(key).prev;
            Node next = nodeMap.get(key).next;
            prev.next = next;
            next.prev = prev;
            nodeMap.get(key).val = val;
            prev = tail.prev;
            prev.next = nodeMap.get(key);
            nodeMap.get(key).prev = prev;
            nodeMap.get(key).next = tail;
            tail.prev = nodeMap.get(key);
        } else {
            while (size >= cap) {
                int key1 = head.next.key;
                mergeTwoNode(head, head.next.next);
                nodeMap.remove(key1);
                size--;
            }
            Node node = new Node();
            node.key = key;
            node.val = val;
            nodeMap.put(key, node);
            mergeTwoNode(tail.prev, node);
            mergeTwoNode(node, tail);
            size++;
        }

    }
    private void mergeTwoNode(Node prev, Node next) {
        prev.next = next;
        next.prev = prev;
    }

}
