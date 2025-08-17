package com.prectice.leetcode_100_review2.二叉树2;

import com.prectice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 17:08
 */
public class algorithm_114 {

    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        dfs(root);
        TreeNode temp = root;
        queue.poll();

        while (!queue.isEmpty()) {
            temp.left = null;
            TreeNode poll = queue.poll();
            temp.right = poll;
            temp = temp.right;
        }
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.offer(root);
        dfs(root.left);
        dfs(root.right);
    }
}
