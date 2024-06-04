package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description: 对称二叉树
 * @since 2024-05-31 11:14
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
