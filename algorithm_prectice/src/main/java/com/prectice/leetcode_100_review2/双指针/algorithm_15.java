package com.prectice.leetcode_100_review2.双指针;

import java.sql.Array;
import java.util.*;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-23 20:23
 */
public class algorithm_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> resultList = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                if (left > i+1 && nums[left] == nums[left-1]) {
                    left++;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(List.of(nums[i] ,nums[left], nums[right]));
                    if (nums[left] == nums[right]) {
                        break;
                    }
                    left++;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(resultList);
    }

}
