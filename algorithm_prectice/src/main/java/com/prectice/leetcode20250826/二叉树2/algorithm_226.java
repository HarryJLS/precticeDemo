package com.prectice.leetcode20250826.二叉树2;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 15:33
 */
public class algorithm_226 {

    public TreeNode invertTree(TreeNode root) {
        return swapTree(root);
    }

    private TreeNode swapTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = swapTree(root.left);
        TreeNode right = swapTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
