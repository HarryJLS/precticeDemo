package com.prectice.leetcode_100_review2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2025-08-23 14:36
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class algorithm_116 {



    public Node connect(Node root) {
        Node temp = root;
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        if (root != null) {
            queue1.offer(temp);
        }
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                fillNode(queue1, queue2);
            } else {
                fillNode(queue2, queue1);
            }
        }
        return root;
    }
    private void fillNode(Queue<Node> queue1, Queue<Node> queue2) {
        while (!queue1.isEmpty()) {
            Node poll = queue1.poll();
            poll.next = queue1.isEmpty() ? null :queue1.peek();
            if (poll.left != null) {
                queue2.offer(poll.left);
            }
            if (poll.right != null) {
                queue2.offer(poll.right);
            }
        }
    }
}
