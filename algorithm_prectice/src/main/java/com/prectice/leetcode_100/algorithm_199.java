package com.prectice.leetcode_100;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-11-08 12:40
 */
public class algorithm_199 {

    List<Integer> resultList = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return resultList;
    }

    private void dfs(TreeNode root, int flag) {
        if (root == null) {
            return;
        }
        if (resultList.size() <= flag) {
            resultList.add(root.val);
        }
        flag++;
        dfs(root.right, flag);
        dfs(root.left, flag);
    }
}
