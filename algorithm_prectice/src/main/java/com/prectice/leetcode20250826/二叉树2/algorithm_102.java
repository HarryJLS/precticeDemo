package com.prectice.leetcode20250826.二叉树2;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 16:14
 */
public class algorithm_102 {
    public List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                List<Integer> tempList = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    TreeNode poll = queue1.poll();
                    tempList.add(poll.val);
                    if (poll.left != null) {
                        queue2.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue2.offer(poll.right);
                    }
                }
                resultList.add(tempList);
            } else {
                List<Integer> tempList = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    TreeNode poll = queue2.poll();
                    tempList.add(poll.val);
                    if (poll.left != null) {
                        queue1.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue1.offer(poll.right);
                    }
                }
                resultList.add(tempList);
            }
        }
        return resultList;

    }
}
