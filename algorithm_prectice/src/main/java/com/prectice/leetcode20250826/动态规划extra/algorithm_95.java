package com.prectice.leetcode20250826.动态规划extra;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description: 不同的二叉搜索树 遍历
 * @since 2025-08-27 17:13
 */
public class algorithm_95 {

    public List<TreeNode> generateTrees(int n) {

        return buildTree(1, n);


    }

    private List<TreeNode> buildTree(int left, int right) {
        List<TreeNode> allTreeNodeList = new ArrayList<>();
        if (left > right) {
            allTreeNodeList.add(null);
            return allTreeNodeList;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = buildTree(left, i - 1);
            List<TreeNode> rightList = buildTree(i + 1, right);

            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode head = new TreeNode(i);
                    head.left = leftNode;
                    head.right = rightNode;
                    allTreeNodeList.add(head);
                }
            }
        }
        return allTreeNodeList;
    }
}
