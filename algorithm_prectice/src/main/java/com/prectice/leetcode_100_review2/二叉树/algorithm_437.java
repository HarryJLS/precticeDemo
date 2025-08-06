package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-06 10:18
 */
public class algorithm_437 {

    Integer result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfsNode(root, targetSum);
        return result;
    }

    private void dfsNode(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        dfsNode(root.left, targetSum);
        dfsNode(root.right, targetSum);
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
