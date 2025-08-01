package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-31 20:22
 */
public class algorithm_543 {

    public int routh = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findRouth(root);
        return routh - 1;
    }

    private int findRouth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findRouth(root.left);
        int right = findRouth(root.right);
        routh = Math.max(routh, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
