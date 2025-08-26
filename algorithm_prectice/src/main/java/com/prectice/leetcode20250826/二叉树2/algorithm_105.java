package com.prectice.leetcode20250826.二叉树2;

import com.prectice.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 23:42
 */
public class algorithm_105 {

    public Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }
    private TreeNode build(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int midIndex = inorderMap.get(preorder[preLeft]);
        int length = midIndex - inLeft;
        TreeNode head = new TreeNode(preorder[preLeft]);
        head.left = build(preorder, preLeft +1, preLeft +length, inLeft, midIndex - 1);
        head.right = build(preorder, preLeft + length + 1, preRight, midIndex + 1, inRight);
        return head;
    }
}
