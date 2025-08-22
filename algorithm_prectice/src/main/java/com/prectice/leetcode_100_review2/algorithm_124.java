package com.prectice.leetcode_100_review2;

import com.prectice.leetcode.TreeNode;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-22 11:36
 */
public class algorithm_124 {

    public int maxSum = -1000;
    public int maxPathSum(TreeNode root) {
        dfsSum(root);
        return maxSum;
    }
    private int dfsSum(TreeNode root) {
        if (root == null) {
            return -1000;
        }
        int left = dfsSum(root.left);
        int right = dfsSum(root.right);
        maxSum = Math.max(root.val + left + right, maxSum);
        maxSum = Math.max(root.val +  Math.max(left, right), maxSum);
        maxSum = Math.max(root.val, maxSum);
        maxSum = Math.max(maxSum, Math.max(left, right));
        return root.val + Math.max(Math.max(left, right), 0);
    }

    public static void main(String[] args) {
        algorithm_124 algorithm124 = new algorithm_124();
        TreeNode root = new TreeNode(-3);
        algorithm124.maxPathSum(root);
        System.out.println(algorithm124.maxSum);
    }


}
