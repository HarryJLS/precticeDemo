package com.prectice.leetcode_100_review2.链表2;

import com.prectice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-22 11:06
 */
public class algorithm_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        if (p != null) {
            pQueue.offer(p);
        }
        if (q != null) {
            qQueue.offer(q);
        }
        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pPoll = pQueue.poll();
            TreeNode qPoll = qQueue.poll();
            if (!compareNode(pPoll, qPoll) || !compareNode(pPoll.left, qPoll.left) || !compareNode(pPoll.right,
                    qPoll.right)) {
                return false;
            }
            if (pPoll.left != null) {
                pQueue.offer(pPoll.left);
            }
            if (qPoll.left != null) {
                qQueue.offer(qPoll.left);
            }
            if (pPoll.right != null) {
                pQueue.offer(pPoll.right);
            }
            if (qPoll.right != null) {
                qQueue.offer(qPoll.right);
            }
        }
        if (pQueue.isEmpty() && qQueue.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean compareNode(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
