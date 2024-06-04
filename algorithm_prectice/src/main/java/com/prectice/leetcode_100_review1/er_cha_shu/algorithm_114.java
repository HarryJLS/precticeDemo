package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2024-06-03 11:35
 */
public class algorithm_114 {

    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        reverse(root);
        TreeNode temp = root;
        queue.poll();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            temp.left = null;
            temp.right = poll;
            temp = temp.right;
        }
        temp.left = null;
        temp.right = null;
    }
    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.offer(root);
        reverse(root.left);
        reverse(root.right);
    }
}
