package com.prectice.leetcode_100_review2.二叉树2;

import com.prectice.leetcode.TreeNode;
import jdk.javadoc.internal.doclets.toolkit.taglets.snippet.Style;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 15:45
 */
public class algorithm_101 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        if (root.left != null) {
            leftQueue.offer(root.left);
        }
        if (root.right != null) {
            rightQueue.offer(root.right);
        }
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftPoll = leftQueue.poll();
            TreeNode rightPoll = rightQueue.poll();
            if (!compareNode(leftPoll, rightPoll) || !compareNode(leftPoll.left, rightPoll.right) || !compareNode(leftPoll.right, rightPoll.left)) {
                return false;
            }
            else {
                if (leftPoll.left != null) {
                    leftQueue.offer(leftPoll.left);
                    rightQueue.offer(rightPoll.right);
                }
                if (leftPoll.right != null) {
                    leftQueue.offer(leftPoll.right);
                    rightQueue.offer(rightPoll.left);
                }
            }
        }
        if (leftQueue.isEmpty() && rightQueue.isEmpty()) {
            return true;
        }
        return false;

    }


    private boolean compareNode (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
