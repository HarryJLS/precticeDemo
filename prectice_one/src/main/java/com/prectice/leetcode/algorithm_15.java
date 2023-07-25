package com.prectice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author JLS
 * @description:
 * @since 2023-07-24 20:23
 */
public class algorithm_15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultGroup = new ArrayList<>();
        if (nums.length == 3 && nums[0] + nums[1] + nums[2] == 0) {
            resultGroup.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return resultGroup;
        }

        // 数组排序
        Arrays.sort(nums);
        int length = nums.length;
//        int index = 0;
        int temp = 0;
        int left = 0;
        int right = 0;
        for (int index = 0; index < length - 2; index++) {

            temp = nums[index];
            if (index > 0 && nums[index-1] == nums[index]) {
                continue;
            }

            if (temp > 0) {
                break;
            }

            left = index + 1;
            right = length - 1;

            while (right >left && right < length) {

                int sum = temp + nums[left] + nums[right];
                if (sum == 0 && resultGroup.size() == 0) {
                    resultGroup.add(Arrays.asList(temp, nums[left], nums[right]));

                } else if(sum == 0 && resultGroup.size() != 0) {
                    if (resultGroup.get(resultGroup.size()-1).get(1) != nums[left] || resultGroup.get(resultGroup.size()-1).get(0) != temp) {
                        resultGroup.add(Arrays.asList(temp, nums[left], nums[right]));
                        left++;
                        right--;
                    } else {
                        left++;
                        right--;
                    }

                }else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }

        }

        return resultGroup;

    }

}
