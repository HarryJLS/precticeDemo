package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-11-20 12:18
 */
public class algorithm_46 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> temp = new ArrayList<>();
        dfs(temp, nums);
        return result;

    }

    private void dfs(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {

            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(list, nums);
                // 移除当前列表中最后的一个数字，换上下一个数字
                list.remove(list.size() - 1);
            }
        }
    }
}
