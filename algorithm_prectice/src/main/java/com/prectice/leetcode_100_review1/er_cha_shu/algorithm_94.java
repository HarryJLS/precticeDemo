package com.prectice.leetcode_100_review1.er_cha_shu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2024-05-31 10:35
 */
public class algorithm_94 {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        reverse(root);
        return list;
    }

    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        reverse(root.left);
        list.add(root.val);
        reverse(root.right);
    }

    private List<Integer> resultList = new ArrayList<>();

    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root.left != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                resultList.add(root.val);
                root = root.right;
            }
        }
        return resultList;
    }

}
