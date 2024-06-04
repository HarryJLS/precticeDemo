package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-03 11:29
 */
public class algorithm_199 {

    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return list;
        }
        reverse(root, 1);
        return list;
    }

    private void reverse(TreeNode root, int flag) {
        if (root == null) {
            return;
        }
        if (list.size() < flag) {
            list.add(root.val);
        }
        flag++;
        reverse(root.right, flag);
        reverse(root.left, flag);
    }
}
