package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-08-09 12:59
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public int deep;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
