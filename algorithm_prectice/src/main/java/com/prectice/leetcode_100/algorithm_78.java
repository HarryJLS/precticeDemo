package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-11-20 12:36
 */
public class algorithm_78 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        for (int i = 0; i <= nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            dfs(list, i, nums, 0);
        }

        return result;

    }

    private void dfs(List<Integer> list, int size, int[] nums, int index) {
        if (list.size() == size) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(list, size, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
