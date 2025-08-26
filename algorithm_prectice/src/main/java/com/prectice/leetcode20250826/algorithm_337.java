package com.prectice.leetcode20250826;

import com.prectice.leetcode.TreeNode;

import java.util.Stack;

/**
 * @author JLS
 * @description:
 * @since 2025-08-23 15:18
 */
public class algorithm_337 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Integer> stock = new Stack<>();
        stock.empty();
        stock.peek();
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int select = root.val + left[1] +right[1];
        int noSelect = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{select, noSelect};
    }

}
