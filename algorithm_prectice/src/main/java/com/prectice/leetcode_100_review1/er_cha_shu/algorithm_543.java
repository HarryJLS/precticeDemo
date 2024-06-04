package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2024-06-03 09:53
 */
public class algorithm_543 {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;

    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = root.left == null ? 0 : dfs(root.right) + 1;
        int right = root.right == null ? 0 : dfs(root.right) + 1;

        max = Math.max(left + right, max);
        return Math.max(left, right);
    }
}

