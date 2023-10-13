package com.prectice.leetcode_100;

import java.util.LinkedList;

/**
 * @author JLS
 * @description:
 * @since 2023-09-21 12:22
 */
public class algorithm_239 {

    /**
     * 核心思想就是利用双向队列来操作
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (k == 1) {
            return nums;
        }

        // 用于当移动窗口，且最大的数字排在前面
        LinkedList<Integer> list = new LinkedList<>();
        // 用于保存最后的返回结果
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        // 遍历所有的元素
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                while (!list.isEmpty() && list.getLast() < nums[i]) {
                    list.removeLast();
                }
                list.addLast(nums[i]);
            }
            // 当第一次遍历了k个数字，获取一次最大值数字
            if (i == k-1) {
                result[index++] = list.getFirst();
            }

            if (i >= k) {
                // 删除过期元素
                if (!list.isEmpty() && list.getFirst() == nums[i-k]) {
                    list.removeFirst();
                }
                while (!list.isEmpty() && list.getLast() < nums[i]) {
                    list.removeLast();
                }
                list.addLast(nums[i]);
                result[index++] = list.getFirst();


            }

        }

        return result;

    }
}
