package com.prectice.leetcode_100_review2.二叉树2;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 16:09
 */
public class algorithm_543 {

    public int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;

    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }
}
