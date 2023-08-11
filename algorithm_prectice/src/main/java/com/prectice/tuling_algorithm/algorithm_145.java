package com.prectice.tuling_algorithm;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-08-11 13:11
 */
public class algorithm_145 {

    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        reverse(root);
        return list;
    }

    public void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        reverse(root.left);
        reverse(root.right);
        list.add(root.val);
    }
}
