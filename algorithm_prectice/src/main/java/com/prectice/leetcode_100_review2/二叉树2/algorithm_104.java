package com.prectice.leetcode_100_review2.二叉树2;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 15:24
 */
public class algorithm_104 {

    public int depth = 0;
    public int maxDepth(TreeNode root) {
        findDepth(root, 0);
        return depth;
    }
    private void findDepth(TreeNode root, int dep) {
        if (root == null) {
            return;
        }
        dep++;
        depth = Math.max(depth, dep);
        findDepth(root.left, dep);
        findDepth(root.right, dep);
    }
}
