package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-31 19:30
 */
public class algorithm_104 {

    public int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        findDepth(root, 0);
        return maxDepth;
    }

    private void findDepth(TreeNode root, int depth) {
        if (root != null) {
            depth += 1;
        } else {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        findDepth(root.left, depth);
        findDepth(root.right, depth);
    }

}
