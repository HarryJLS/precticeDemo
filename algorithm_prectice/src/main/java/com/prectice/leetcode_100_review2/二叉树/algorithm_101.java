package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-31 19:45
 */
public class algorithm_101 {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        TreeNode leftTemp = root.left;
        TreeNode rightTemp = root.right;
        while (leftTemp != null) {
            leftQueue.offer(leftTemp);
            leftTemp = leftTemp.left;
        }
        while (rightTemp != null) {
            rightQueue.offer(rightTemp);
            rightTemp = rightTemp.right;
        }
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.poll();
            if (!compareNode(left.left, right.right) || !compareNode(left.right, right.left) || !compareNode(left,
                    right)) {
                return false;
            }
            if (left.left != null) {
                leftQueue.offer(left.left);
            }
            if (right.right != null) {
                rightQueue.offer(right.right);
            }
            if (left.right != null) {
                leftQueue.offer(left.right);
            }
            if (right.left != null) {
                rightQueue.offer(right.left);
            }
        }
        if (leftQueue.isEmpty() && rightQueue.isEmpty()) {
            return true;
        }
        return false;
    }

    private Boolean compareNode(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return true;
        }
        return false;
    }
}
