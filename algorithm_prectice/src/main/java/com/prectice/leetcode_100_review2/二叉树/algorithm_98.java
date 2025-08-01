package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-31 20:58
 */
public class algorithm_98 {

    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
