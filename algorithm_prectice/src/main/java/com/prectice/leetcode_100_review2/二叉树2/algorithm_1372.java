package com.prectice.leetcode_100_review2.二叉树2;

import com.prectice.leetcode.TreeNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-22 14:30
 */
public class algorithm_1372 {


    public int maxRoute = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfsRoute(root, 0, 0);
        dfsRoute(root, 1, 0);
        return maxRoute - 1;
    }


    private void dfsRoute(TreeNode root, int flag, int sum) {
        if (root == null) {
            return;
        }
        sum++;
        maxRoute = Math.max(maxRoute, sum);
        if (flag == 0) {
            dfsRoute(root.left, 1, sum);
            dfsRoute(root.right, 0, 1);
        } else {
            dfsRoute(root.right, 0, sum);
            dfsRoute(root.left, 1, 1);
        }
    }
}
