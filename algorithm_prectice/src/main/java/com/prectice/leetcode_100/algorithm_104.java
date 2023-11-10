package com.prectice.leetcode_100;

import com.prectice.leetcode.ListNode;
import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2023-10-31 12:22
 */
public class algorithm_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int num) {
        if (root == null) {
            return num;
        }
        num++;
        int leftNum = dfs(root.left, num);
        int rightNum = dfs(root.right, num);
        return Math.max(leftNum, rightNum);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, null, null));
        algorithm_104 algorithm104 = new algorithm_104();
        System.out.println(algorithm104.maxDepth(treeNode));

    }

}
