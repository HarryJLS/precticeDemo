package com.prectice.leetcode_100_review2.二叉树2;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 23:55
 */
public class algorithm_437 {

    public int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }

    private void dfs(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        dfsSum(root, targetSum);
    }
    private void dfsSum(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        if (targetSum == root.val) {
            result++;
        }
        dfsSum(root.left, targetSum - root.val);
        dfsSum(root.right, targetSum - root.val);
    }
}
