package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-10-30 12:25
 */
public class LRUCache {

    private final HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    private int cap;

    private int size = 0;
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }
    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node();
        head.key = -1;
        head.val = -1;
        tail = new Node();
        tail.key = -1;
        tail.val = -1;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        } else {
            map.get(key).next.prev = map.get(key).prev;
            map.get(key).prev.next = map.get(key).next;
            Node next = head.next;
            next.prev = map.get(key);
            map.get(key).next = next;
            map.get(key).prev = head;
            head.next = map.get(key);
            return map.get(key).val;
        }
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            this.get(key);
            map.get(key).val = value;
        } else {
            Node node = new Node();
            node.key = key;
            node.val = value;
            Node temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
            size++;
            while (size > cap) {
                map.remove(tail.prev.key);
                Node tailtemp = tail.prev.prev;
                tailtemp.next = tail;
                tail.prev = tailtemp;
                size--;
            }
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

    }
}
