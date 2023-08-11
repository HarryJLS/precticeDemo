package com.prectice.tuling_algorithm;

import com.prectice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2023-08-09 12:58
 */
public class algorithm_111 {

    // 深度优先 ，核心思想是遍历所有路线，再比较所有值取最小值
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min+1;

    }

    // 广度优先  核心思想是一层一层下去，走到目的地就停止；
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 声明一个先入先出的队列，用于暂时保存数据
        Queue<TreeNode> queue = new LinkedList<>();
        root.deep = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left == null && treeNode.right == null) {
                return treeNode.deep;
            }
            if (treeNode.left != null) {
                treeNode.left.deep = treeNode.deep + 1;
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                treeNode.right.deep = treeNode.deep + 1;
                queue.offer(treeNode.right);
            }
        }
        return 0;
    }
}
