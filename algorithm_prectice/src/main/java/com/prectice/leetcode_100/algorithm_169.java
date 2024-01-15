package com.prectice.leetcode_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2024-01-10 12:37
 */
public class algorithm_169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        int size = -1;
        int left = 0;
        int right = 0;
        while (left < nums.length && right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                if (right - left > size) {
                    size = right-left;
                    num = nums[left];
                }
                left = right;
            }

        }
        if (right - left > size) {
            num = nums[left];
        }
        return num;
    }
    public int majorityElement1(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int size = 0;
        int num = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > size) {
                size = entry.getValue();
                num = entry.getKey();
            }
        }
        return num;
    }

    public int majorityElement2(int[] nums) {
        int sum = 0;
        int tamp = -1;
        for (int num : nums) {
            if (sum == 0) {
                sum = 1;
                tamp = num;
            } else {
                if (tamp == num) {
                    sum++;
                } else {
                    sum--;
                }
            }
        }
        return tamp;
    }


    public static void main(String[] args) {
        algorithm_169 algorithm169 = new algorithm_169();
        int[] nums = new int[]{3,3,4};
        System.out.println(algorithm169.majorityElement1(nums));
    }
}
