package com.prectice.tuling_algorithm;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-08-11 13:09
 */
public class algorithm_94 {

    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        reverse(root);
        return list;
    }

    public void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        reverse(root.left);
        list.add(root.val);
        reverse(root.right);
    }
}
