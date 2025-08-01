package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-31 19:17
 */
public class algorithm_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stock = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        while (!stock.isEmpty() || root != null) {
            if (root != null) {
                stock.push(root);
                root = root.left;
            } else {
                TreeNode pop = stock.pop();
                resultList.add(pop.val);
                root = pop.right;
            }
        }
        return resultList;
    }
}
