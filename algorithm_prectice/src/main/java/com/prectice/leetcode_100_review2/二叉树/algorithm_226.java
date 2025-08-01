package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-31 19:38
 */
public class algorithm_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
