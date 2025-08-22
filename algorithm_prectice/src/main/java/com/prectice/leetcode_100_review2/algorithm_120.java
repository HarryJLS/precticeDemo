package com.prectice.leetcode_100_review2;

import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-21 19:16
 */
public class algorithm_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] nums = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0) {
                    nums[i][j] = triangle.get(i).get(j);
                    continue;
                }
                if (j == 0) {
                    nums[i][j] = nums[i-1][j] + triangle.get(i).get(j);
                    continue;
                }
                if (i == j) {
                    nums[i][j] = nums[i-1][j-1] + triangle.get(i).get(j);
                    continue;
                }
                nums[i][j] = Math.min(nums[i-1][j-1], nums[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            result = Math.min(result, nums[triangle.size() - 1][i]);
        }
        return result;
    }
}
