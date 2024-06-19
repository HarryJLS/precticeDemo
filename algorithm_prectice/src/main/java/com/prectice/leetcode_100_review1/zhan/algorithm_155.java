package com.prectice.leetcode_100_review1.zhan;

import lombok.val;

/**
 * @author JLS
 * @description:
 * @since 2024-06-17 16:25
 */
public class algorithm_155 {

    Node head = null;

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            int min = head.min;
            head = new Node(val, Math.min(min, val), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

        Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }
}
