package com.prectice.leetcode_100;

import com.prectice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2023-11-13 12:53
 */
public class algorithm_236 {

    private TreeNode node = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);
        return node;

    }
    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int flag = 0;
        if (root == p || root == q) {
            flag = 1;
        }
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        if (flag == 1 && flag + left + right == 2) {
            node = root;
        } else if (left == 1 && right == 1) {
            node = root;
        }
        return flag + left + right;
    }



}
