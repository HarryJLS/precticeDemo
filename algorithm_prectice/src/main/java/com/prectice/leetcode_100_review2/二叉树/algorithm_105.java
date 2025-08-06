package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-05 20:28
 */
public class algorithm_105 {

    public Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return generateNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode generateNode(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int leftLength = inorderMap.get(preorder[preLeft]) - inLeft;
        root.left = generateNode(preorder, preLeft + 1, preLeft + leftLength, inorder, inLeft,
                inorderMap.get(preorder[preLeft]) - 1);
        root.right = generateNode(preorder, preLeft + 1 + leftLength, preRight, inorder,
                inorderMap.get(preorder[preLeft]) + 1, inRight);
        return root;
    }

}
