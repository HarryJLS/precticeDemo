package com.prectice.leetcode20250826.二叉树2;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-18 00:08
 */
public class algorithm_236 {

    public TreeNode node = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return node;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int flag = 0;
        if (root == p || root == q) {
            flag = 1;
        }
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        if (flag == 1 && flag + left + right == 2) {
            node = root;
        } else if (left == 1 && right == 1) {
            node = root;
        }
        return flag + left + right;
    }
}
