package com.prectice.leetcode_100_review2.二叉树2;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 16:43
 */
public class algorithm_98 {

    public List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        reverse(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }
    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        reverse(root.left);
        list.add(root.val);
        reverse(root.right);
    }
}
