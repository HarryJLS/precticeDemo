package com.prectice.leetcode20250826.二叉树2;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2025-08-17 16:25
 */
public class algorithm_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = buildTree(nums, left, mid - 1);
        head.right = buildTree(nums, mid +1, right);
        return head;
    }
}
