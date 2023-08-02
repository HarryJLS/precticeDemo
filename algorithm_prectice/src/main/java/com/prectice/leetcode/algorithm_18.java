package com.prectice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JLS
 * @description:
 * @since 2023-07-24 21:24
 */
public class algorithm_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resultGroup = new ArrayList<>();
        if (nums.length == 4) {
            long sum = (long)nums[0] + (long)nums[1] + (long)nums[2] + (long)nums[3];
            if (sum == target) {
                resultGroup.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return resultGroup;
            }
        }

        // 数组排序
        Arrays.sort(nums);
        int length = nums.length;
        // int index = 0;
        int temp = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if (target <= 0 && nums[i] > 0) {
                break;
            }

            for (int index = i + 1; index < length - 2; index++) {

                temp = nums[index];
                if (index > i + 1 && nums[index - 1] == nums[index]) {
                    continue;
                }

//                if (temp > target - nums[i]) {
//                    break;
//                }

                left = index + 1;
                right = length - 1;

                while (right > left && right < length) {

                    int sum = temp + nums[left] + nums[right];
                    if (sum == target - nums[i] && resultGroup.size() == 0) {
                        resultGroup.add(Arrays.asList(nums[i], temp, nums[left], nums[right]));

                    } else if (sum == target - nums[i] && resultGroup.size() != 0) {
                        if (resultGroup.get(resultGroup.size() - 1).get(2) != nums[left] || resultGroup.get(resultGroup.size() - 1).get(1) != temp
                                || resultGroup.get(resultGroup.size() - 1).get(0) != nums[i]) {
                            resultGroup.add(Arrays.asList(nums[i], temp, nums[left], nums[right]));
                            left++;
                            right--;
                        } else {
                            left++;
                            right--;
                        }

                    } else if (sum > target - nums[i]) {
                        right--;
                    } else if (sum < target - nums[i]) {
                        left++;
                    }
                }

            }
        }

        return resultGroup;

    }
}
