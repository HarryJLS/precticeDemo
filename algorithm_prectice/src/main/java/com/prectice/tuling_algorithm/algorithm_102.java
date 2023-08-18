package com.prectice.tuling_algorithm;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2023-08-14 12:32
 */
public class algorithm_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recourse(root, 1, list);
        int temp = 1;
        int length = list.size();
        int flag = 0;
        while (length >= temp || length > flag) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = flag + 1; i <= temp; i++) {
                if (i >= length) {
                    break;
                }
                if (list.get(i) != null) {
                    tempList.add(list.get(i));
                }
            }
            if (tempList.size() > 0) {
                resultList.add(tempList);
            }
            flag = temp;
            temp = (temp + 1) * 2 - 1;
        }
        return resultList;
    }

    private void recourse (TreeNode root, int i, List<Integer> list) {
        if (root == null) {
            return;
        }
        int length = list.size();

        if (length <= i) {
            for (int j = 0; j <= i - length; j++) {
                list.add(length + j, null);
            }
        }
        list.set(i, root.val);
        recourse(root.left, i * 2, list);
        recourse(root.right, i * 2 + 1, list);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        List<List<Integer>> resultList = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                List<Integer> tempList = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    TreeNode poll = queue1.poll();
                    tempList.add(poll.val);
                    if (poll.left != null) {
                        queue2.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue2.offer(poll.right);
                    }
                }
                resultList.add(tempList);
            } else if (!queue2.isEmpty()) {
                List<Integer> tempList = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    TreeNode poll = queue2.poll();
                    tempList.add(poll.val);
                    if (poll.left != null) {
                        queue1.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue1.offer(poll.right);
                    }
                }
                resultList.add(tempList);

            }
        }
        return resultList;
    }



    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(15, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(9, null, null);
        TreeNode node3 = new TreeNode(20, node6, node7);
        TreeNode node1 = new TreeNode(3, node2, node3);
        algorithm_102 algorithm102 = new algorithm_102();
        List<List<Integer>> lists = algorithm102.levelOrder1(node1);
        System.out.println(lists.toString());
    }
}
