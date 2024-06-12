package com.prectice.leetcode_100_review1.hui_su;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-07 11:03
 */
public class algorithm_39 {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> temp = new ArrayList<>();
        reverse(temp, candidates, target, 0, 0);
        return list;
    }

    private void reverse(List<Integer> temp, int[] candidates, int target, int sum, int index) {
        if (index >= candidates.length) {
            return;
        }
        if (sum == target) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target) {
            return;
        }
        temp.add(candidates[index]);
        sum += candidates[index];
        reverse(temp, candidates, target, sum, index);
        temp.remove(temp.size() - 1);
        sum -= candidates[index];
        reverse(temp, candidates, target, sum, index+1);
    }
}
