package com.prectice.leetcode_100_review1.er_cha_shu;

import com.prectice.leetcode.TreeNode;

/**
 * @author JLS
 * @description:
 * @since 2024-07-17 10:47
 */
public class algorithm_144 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return root;
        }
        TreeNode temp = root.right;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(temp);

        return  root;
    }
}
