package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2024-06-04 12:40
 */
public class algorithm_236 {

    TreeNode node = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);
        return node;
    }
    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        // 用于标记当前的root是否为p或者q
        int flag = 0;
        if (root == p || root == q) {
            flag = 1;
        }
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        if (flag == 1 && flag + left + right == 2) {
            node = root;
        } else if (flag + left + right == 2) {
            node = root;
        }
        return flag + left + right;
    }
}
