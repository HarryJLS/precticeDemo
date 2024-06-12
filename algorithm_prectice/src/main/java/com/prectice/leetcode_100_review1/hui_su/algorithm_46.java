package com.prectice.leetcode_100_review1.hui_su;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-06 10:35
 */
public class algorithm_46 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        reverse(nums, temp);
        return result;
    }
    private void reverse(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                reverse(nums, list);
                list.remove(list.size()-1);
            }
        }
    }
}
