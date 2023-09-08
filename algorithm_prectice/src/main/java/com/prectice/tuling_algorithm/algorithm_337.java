package com.prectice.tuling_algorithm;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2023-09-04 12:57
 */
public class algorithm_337 {

    public int rob(TreeNode root) {

        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    /**
     * 深度优先
     */
    protected int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int select = root.val + left[1] + right[1];
        int noSelect = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] { select, noSelect };
    }
}
