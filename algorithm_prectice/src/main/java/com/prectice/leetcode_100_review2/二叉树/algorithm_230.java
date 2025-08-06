package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-05 19:20
 */
public class algorithm_230 {

    public List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        reverse(root);
        return list.get(k-1);
    }
    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            reverse(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            reverse(root.right);
        }
    }
}
