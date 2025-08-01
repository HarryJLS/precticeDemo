package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

import java.util.*;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-31 20:33
 */
public class algorithm_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        List<List<Integer>> resultList = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            if (!queue1.isEmpty()) {
                deal(queue1, tempList, queue2);
                resultList.add(tempList);
                continue;
            }
            if (!queue2.isEmpty()) {
                deal(queue2, tempList, queue1);
                resultList.add(tempList);
            }
        }
        return resultList;
    }

    private void deal(Queue<TreeNode> queue1, List<Integer> tempList, Queue<TreeNode> queue2) {
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
    }
}
