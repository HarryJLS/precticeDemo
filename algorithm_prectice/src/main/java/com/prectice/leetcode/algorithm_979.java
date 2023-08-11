package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-14 10:33
 */
public class algorithm_979 {

    /**
     * 解题思路：首先这个是在二叉树移动硬币的题目，题目中已给二叉树的封装类 题目的关键点在于每一个节点都要有一个硬币，所以，加入一个节点上如果只有一个硬币，则既不需要移入，又不需要移除，
     * 假如其它节点需要经过这个节点移动硬币，完全可以视为先将硬币移到中间节点，由中间节点来负责移动到另外一侧
     * 由于是二叉树，所以自然从二叉树的最高的根节点开始进行计算，只计算左右节点的。因为是二叉树，深度不知，多以则通过递归的方法来遍历每一个节点来进行处理
     * 每一个节点上的值，扣除掉左右需要的数量和可以移出的数量再减一，计算可以得到总共的可移动的数量并且保证了小二叉树上的顶点是有一个硬币的
     * 然后通过类似动态规划的方法，将问题细化，只考虑移动到附近节点所需要移动的次数，层层往上就刚好计算出所有需要移动步数。
     */
    int move = 0;

    public int distributeCoins(TreeNode root) {

        removeCoin(root);
        return move;
    }

    public int removeCoin(TreeNode root) {
        // 到末梢的叶子节点，则不用统计
        if (root == null) {
            return 0;
        }

        // 计算左右分支各需要移动多少硬币，正数移出，负数移入，0不动
        int left = removeCoin(root.left);
        int right = removeCoin(root.right);
        // 这里取绝对值，是因为你移入和移出都是要消耗步数的，所以绝对值相加
        move += Math.abs(left) + Math.abs(right);

        // 计算出每一个节点可移动硬币数量，如果是0，说明不需要硬币流动，如果是正数，说明有硬币可以移出，相反负数，说明硬币需要移入
        return root.val + left + right - 1;
    }
}

