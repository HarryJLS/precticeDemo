package com.prectice.leetcode_100_review1.hui_su;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-06 10:47
 */
public class algorithm_78 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            reverse(list, i, 0, nums);
        }
        return result;
    }
    private void reverse(List<Integer> list, int size, int index, int[] nums) {
        if (list.size() == size) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                reverse(list, size, i+1, nums);
                list.remove(list.size()-1);
            }
        }
    }
}
