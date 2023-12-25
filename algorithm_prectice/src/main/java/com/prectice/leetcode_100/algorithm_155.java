package com.prectice.leetcode_100;

import java.util.Stack;

/**
 * @author JLS
 * @description:
 * @since 2023-12-07 12:26
 */
public class algorithm_155 {

    Node head = null;

    public algorithm_155() {

    }

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
        Node(int val, int min) {
            this.val = val;
            this.min = min;
            next = null;
        }
        Node(int val, int min, Node node) {
            this.val = val;
            this.min = min;
            this.next = node;
        }

    }
}
