package com.prectice.leetcode_100;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-11-02 12:52
 */
public class algorithm_230 {

    private List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        reverse(root);
        if (k > list.size() || k < 1) {
            return -1;
        }
        return list.get(k-1);

    }

    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        reverse(root.left);
        list.add(root.val);
        reverse(root.right);
    }
}
