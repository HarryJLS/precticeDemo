package com.prectice.leetcode_100;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2023-11-01 12:14
 */
public class algorithm_543 {

    // 二叉树的直径,换种想法是求每个节点的左右子树的深度和
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
        int left = root.left == null ? 0 : dfs(root.left) + 1;
        int right = root.right == null ? 0 : dfs(root.right) + 1;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
