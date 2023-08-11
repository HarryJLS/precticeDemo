package com.prectice.tuling_algorithm;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-08-11 12:51
 */
public class algorithm_144 {

    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        reverse(root);
        return list;
    }

    public void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        reverse(root.left);
        reverse(root.right);
    }
}
