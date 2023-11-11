package com.prectice.leetcode_100;

import com.prectice.leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2023-11-10 13:09
 */
public class algorithm_105 {

    // 核心思想，把大的化小，每一节点都是有左右子树，
    public Map<Integer,Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int length = preorder.length;
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTreeNode(preorder, inorder, 0, length-1, 0, length-1);

    }

    private TreeNode buildTreeNode(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        // 获取中间跟节点值,并新建对应树
        int midValue = preorder[pre_left];
        TreeNode root = new TreeNode(midValue);
        // 获取左子树的节点数
        int number = inOrderMap.get(midValue) - in_left;
        root.left = buildTreeNode(preorder, inorder, pre_left + 1, pre_left + number, in_left, inOrderMap.get(midValue) - 1);
        root.right = buildTreeNode(preorder, inorder, pre_left + number + 1, pre_right, inOrderMap.get(midValue) + 1, in_right);
        return root;
    }

}
