package com.prectice.leetcode20250826.二叉树2;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-22 11:21
 */
public class algorithm_113 {

    public List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfsSum(root, targetSum, new ArrayList<>());
        return resultList;
    }

    private void dfsSum(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (targetSum == root.val && root.left == null && root.right == null) {
            resultList.add(list);
        }
        dfsSum(root.left, targetSum - root.val, new ArrayList<>(list));
        dfsSum(root.right, targetSum - root.val, new ArrayList<>(list));
    }

}
