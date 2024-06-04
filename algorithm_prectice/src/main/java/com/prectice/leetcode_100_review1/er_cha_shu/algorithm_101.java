package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description: 对称二叉树
 * @since 2024-05-31 11:24
 */
public class algorithm_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!compareNode(root.left, root.right)) {
            return false;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        if (root.left != null) {
            leftQueue.offer(root.left);
        }
        if (root.right != null) {
            rightQueue.offer(root.right);
        }
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            if (Boolean.TRUE.equals(!compareNode(leftNode.left, rightNode.right)) || Boolean.TRUE.equals(!compareNode(leftNode.right, rightNode.left))) {
                return false;
            } else {
                if (leftNode.left != null) {
                    leftQueue.offer(leftNode.left);
                }
                if (leftNode.right != null) {
                    leftQueue.offer(leftNode.right);
                }
                if (rightNode.right != null) {
                    rightQueue.offer(rightNode.right);
                }
                if (rightNode.left != null) {
                    rightQueue.offer(rightNode.left);
                }
            }
        }
        if (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            return false;
        }
        return true;
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
        } else {
            return false;
        }
    }

}
