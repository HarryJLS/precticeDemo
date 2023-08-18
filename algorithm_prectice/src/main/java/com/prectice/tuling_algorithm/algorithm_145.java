package com.prectice.tuling_algorithm;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author JLS
 * @description: 二叉树后序
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

    public List<Integer> postorderTraversal1(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        // 用于标识右边节点是否有显示过
        TreeNode pev = null;
        while(!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pev) {
                resultList.add(root.val);
                pev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return resultList;
    }
}
