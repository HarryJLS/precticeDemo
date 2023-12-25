package com.prectice.leetcode_100;

import com.prectice.leetcode.TreeNode;


/**
 * @author JLS
 * @description:
 * @since 2023-11-01 12:26
 */
public class algorithm_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return test(0, nums.length-1, nums);
    }
    private TreeNode test(int startIndex, int endIndex, int[] nums) {
        if (startIndex > endIndex) {
            return null;
        }
        int mid = (1 + startIndex + endIndex) / 2;
        TreeNode root = new TreeNode(nums[mid], null, null);
        root.left = test(startIndex, mid - 1, nums);
        root.right = test(mid+1, endIndex, nums);
        return root;
    }

}
