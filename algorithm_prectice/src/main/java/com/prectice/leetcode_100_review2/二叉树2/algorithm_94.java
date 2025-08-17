package com.prectice.leetcode_100_review2.二叉树2;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 15:10
 */
public class algorithm_94 {

    List<Integer> resultList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        reverse(root);
        return resultList;
    }
    private void reverse (TreeNode root) {
        if (root == null) {
            return;
        }
        reverse(root.left);
        resultList.add(root.val);
        reverse(root.right);
    }
}
