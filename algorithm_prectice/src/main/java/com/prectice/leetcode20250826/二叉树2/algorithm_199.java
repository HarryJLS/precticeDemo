package com.prectice.leetcode20250826.二叉树2;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 16:57
 */
public class algorithm_199 {

    public List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root != null) {
            queue1.offer(root);
        }
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                list.add(queue1.peek().val);
                while (!queue1.isEmpty()) {
                    TreeNode poll = queue1.poll();
                    if (poll.right != null) {
                        queue2.offer(poll.right);
                    }
                    if (poll.left != null) {
                        queue2.offer(poll.left);
                    }
                }
            } else {
                list.add(queue2.peek().val);
                while (!queue2.isEmpty()) {
                    TreeNode poll = queue2.poll();
                    if (poll.right != null) {
                        queue1.offer(poll.right);
                    }
                    if (poll.left != null) {
                        queue1.offer(poll.left);
                    }
                }
            }
        }

        return list;

    }
}
