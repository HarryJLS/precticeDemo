package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-31 20:44
 */
public class algorithm_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return generateNode(nums, 0, nums.length - 1);
    }

    private TreeNode generateNode(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = generateNode(nums, left, mid - 1);
        midNode.right = generateNode(nums, mid + 1, right);
        return midNode;
    }
}
