package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2024-06-03 10:14
 */
public class algorithm_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                readVal(queue1, queue2, result);
            } else {
                readVal(queue2, queue1, result);
            }
        }
        return result;
    }

    private void readVal(Queue<TreeNode> queue1, Queue<TreeNode> queue2, List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode poll = queue1.poll();
            list.add(poll.val);
            if (poll.left != null) {
                queue2.offer(poll.left);
            }
            if (poll.right != null) {
                queue2.offer(poll.right);
            }
        }
        result.add(list);
    }

}
