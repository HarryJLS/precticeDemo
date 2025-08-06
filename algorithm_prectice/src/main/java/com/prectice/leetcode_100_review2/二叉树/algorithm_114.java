package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-05 19:58
 */
public class algorithm_114 {

    public Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        getQueue(root);
        root.left = null;
        TreeNode temp = root;
        queue.poll();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            temp.right = poll;
            temp = temp.right;
            temp.left = null;
        }
    }

    private void getQueue(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.offer(root);
        getQueue(root.left);
        getQueue(root.right);
    }
}
