package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description: 二叉树最大深度
 * @since 2024-05-31 10:49
 */
public class algorithm_104 {


    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
    private Integer dfs(TreeNode root, Integer num) {
        if (root == null) {
            return num;
        }
        num++;
        Integer leftDepth = dfs(root.left, num);
        Integer rightDepth = dfs(root.right, num);
        return Math.max(leftDepth, rightDepth);
    }
}
