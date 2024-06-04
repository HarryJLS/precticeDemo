package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-03 11:18
 */
public class algorithm_98 {

    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        reverse(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) >= list.get(i)) {
                return false;
            }
        }
        return true;

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
