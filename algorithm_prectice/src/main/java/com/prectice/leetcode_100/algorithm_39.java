package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-11-20 12:56
 */
public class algorithm_39 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> list = new ArrayList<>();
        dfs(list, candidates, target, 0, 0);
        return result;
    }

    private void dfs(List<Integer> list, int[] candidates, int target, int sum, int index) {
        if (index == candidates.length) {
            return;
        }
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(candidates[index]);
        sum += candidates[index];
        dfs(list, candidates, target, sum, index);
        list.remove(list.size() - 1);
        sum -= candidates[index];
        dfs(list, candidates, target, sum, index + 1);

    }

}
