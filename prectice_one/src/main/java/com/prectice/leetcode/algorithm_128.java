package com.prectice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author JLS
 * @description:
 * @since 2023-07-28 10:27
 */
public class algorithm_128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);
        int result = 0;
        int flag = 1;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] + 1 == nums[i+1]) {
                flag++;
            } else if (nums[i] == nums[i+1]) {
                continue;
            } else {
                result = Math.max(flag, result);
                flag = 1;
            }
        }
        result = Math.max(flag, result);

        return result;
    }

    public static int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
       for (Integer num : set) {
           // 当数字连续数字的最小值时，开始计算
           if (!set.contains(num - 1)) {
               int len = 1;
               int temp = num;
               while (set.contains(temp + 1)) {
                   len++;
                   temp++;
               }
               result = Math.max(result, len);
           }
       }
       return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        longestConsecutive1(nums);
    }
}
