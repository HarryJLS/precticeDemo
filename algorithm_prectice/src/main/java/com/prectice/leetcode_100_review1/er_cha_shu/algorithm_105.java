package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

import java.util.HashMap;

/**
 * @author JLS
 * @description:
 * @since 2024-06-04 10:48
 */
public class algorithm_105 {

    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeNode(preorder, 0, preorder.length-1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeNode(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int leftNum = inorderMap.get(rootValue) - inLeft;
        root.left = buildTreeNode(preorder, preLeft + 1, preLeft + leftNum, inorder, inLeft, inLeft + leftNum);
        root.right = buildTreeNode(preorder, preLeft +leftNum + 1, preRight, inorder, inLeft + leftNum + 1, inRight);
        return root;
    }
}
