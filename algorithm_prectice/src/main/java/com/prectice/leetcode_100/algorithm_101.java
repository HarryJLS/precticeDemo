package com.prectice.leetcode_100;

import com.prectice.leetcode.TreeNode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2023-10-31 12:50
 */
public class algorithm_101 {

    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queueLeft = new LinkedList<>();
        Queue<TreeNode> queueRight = new LinkedList<>();
        if (root == null || (root.right == null && root.left == null)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        if (root.right != null) {
            queueRight.offer(root.right);
        }
        if (root.left != null) {
            queueLeft.offer(root.left);
        }
        if (root.left.val != root.right.val) {
            return false;
        }
        while (!queueLeft.isEmpty() && !queueRight.isEmpty()) {
            TreeNode leftItem = queueLeft.poll();
            TreeNode rightItem = queueRight.poll();
            if ((generate(leftItem.left).val != generate(rightItem.right).val) || (generate(leftItem.right).val != generate(rightItem.left).val)) {
                return false;
            } else {
                if (leftItem.left != null) {
                    queueLeft.offer(leftItem.left);
                }
                if (leftItem.right != null) {
                    queueLeft.offer(leftItem.right);
                }
                if (rightItem.right != null) {
                    queueRight.offer(rightItem.right);
                }
                if (rightItem.left != null) {
                    queueRight.offer(rightItem.left);
                }
            }
        }
        if (!queueLeft.isEmpty() || !queueRight.isEmpty()) {
            return false;
        }
        return true;


    }
    private TreeNode generate(TreeNode node) {
        if (node == null) {
            return new TreeNode(101, null, null);
        } else {
            return node;
        }

    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)), new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null)));
        TreeNode root1 = new TreeNode(1, new TreeNode(0, null, null), null);
        algorithm_101 algorithm101 = new algorithm_101();
        algorithm101.isSymmetric(root1);
    }
}
