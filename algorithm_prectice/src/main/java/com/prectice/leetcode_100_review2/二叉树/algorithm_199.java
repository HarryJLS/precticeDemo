package com.prectice.leetcode_100_review2.二叉树;

import com.prectice.leetcode.TreeNode;
import org.springframework.web.servlet.mvc.LastModified;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-05 19:25
 */
public class algorithm_199 {

    List<Integer> resultList = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        LinkedList<TreeNode> linkedList1 = new LinkedList<>();
        LinkedList<TreeNode> linkedList2 = new LinkedList<>();
        linkedList1.addLast(root);
        while (!linkedList1.isEmpty() || !linkedList2.isEmpty()) {
            if (!linkedList1.isEmpty()) {
                readNode(linkedList1, linkedList2);
            } else {
                readNode(linkedList2, linkedList1);
            }
        }
        return resultList;
    }

    private void readNode(LinkedList<TreeNode> linkedList1, LinkedList<TreeNode> linkedList2) {
        resultList.add(linkedList1.getLast().val);
        while (!linkedList1.isEmpty()) {
            TreeNode treeNode = linkedList1.removeFirst();
            if (treeNode.left != null) {
                linkedList2.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                linkedList2.addLast(treeNode.right);
            }
        }

    }
}
