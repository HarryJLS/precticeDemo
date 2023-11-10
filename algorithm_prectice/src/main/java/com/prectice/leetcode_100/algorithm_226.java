package com.prectice.leetcode_100;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2023-10-31 12:35
 */
public class algorithm_226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }
        swap(root);
        return root;

    }
    private void swap(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return;
        }
        if (left != null) {
            swap(left);
        }
        if (right != null) {
            swap(right);
        }
        root.left = right;
        root.right = left;
    }
}
