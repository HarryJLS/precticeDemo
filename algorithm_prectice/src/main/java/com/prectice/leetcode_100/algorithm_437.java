package com.prectice.leetcode_100;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2023-11-13 12:41
 */
public class algorithm_437 {

    int resultNum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        return resultNum;
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
        if (root.val == targetSum) {
            resultNum++;
        }
        dfsSum(root.left, targetSum - root.val);
        dfsSum(root.right, targetSum - root.val);
    }
}
