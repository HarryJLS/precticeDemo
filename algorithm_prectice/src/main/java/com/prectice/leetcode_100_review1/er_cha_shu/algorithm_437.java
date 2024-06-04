package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2024-06-04 11:28
 */
public class algorithm_437 {

    int result = 0;
    int target = 0;
    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }
        target = targetSum;
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        dfsSum(root, 0);
    }
    private void dfsSum(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        targetSum += root.val;
        if (targetSum == target) {
            result++;
        }
        dfsSum(root.left, targetSum);
        dfsSum(root.right, targetSum);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3), new TreeNode(2));
        algorithm_437 algorithm437 = new algorithm_437();
        System.out.println(algorithm437.pathSum(root, 8));
    }
}
