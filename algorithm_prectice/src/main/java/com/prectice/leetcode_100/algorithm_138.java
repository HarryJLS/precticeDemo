package com.prectice.leetcode_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2023-10-24 12:25
 */
public class algorithm_138 {

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node resultNode = new Node(1);
            Map<Node, Node> nodeMap = new HashMap<>();
            Node copyNode = head;
            while (copyNode != null) {
                Node node = new Node(copyNode.val);
                nodeMap.put(copyNode, node);
                copyNode = copyNode.next;
            }

            copyNode = head;
            resultNode.next = nodeMap.get(head);
            while (copyNode != null) {
                nodeMap.get(copyNode).next = nodeMap.get(copyNode.next);
                nodeMap.get(copyNode).random =  nodeMap.get(copyNode.random);
                copyNode = copyNode.next;
            }
            return resultNode.next;
        }
    }

}
