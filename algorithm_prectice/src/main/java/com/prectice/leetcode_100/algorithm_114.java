package com.prectice.leetcode_100;

import com.prectice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2023-11-08 12:51
 */
public class algorithm_114 {

    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        dfs(root);
        if (queue.isEmpty()) {
            return;
        }
        TreeNode temp = root;
        temp.left = null;
        temp.right = null;
        queue.poll();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            poll.left = null;
            poll.right = null;
            temp.right = poll;
            temp = temp.right;
        }
    }
    private void dfs (TreeNode root) {
        if (root == null) {
            return;
        }
        queue.offer(root);
        dfs(root.left);
        dfs(root.right);
    }
}
