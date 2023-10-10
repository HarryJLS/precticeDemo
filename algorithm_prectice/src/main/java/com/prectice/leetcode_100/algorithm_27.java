package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-09-13 12:26
 */
public class algorithm_27 {

    public int removeElement(int[] nums, int val) {

        if (nums.length == 0) {
            return 0;
        }
        int flag = 0;
        for (int item : nums) {
            if (item != val) {
                flag++;
            }
        }
        return flag;
    }

    public int removeElement1(int[] nums, int val) {

        if (nums.length == 0) {
            return 0;
        }
        int firstIndex = 0;
        int secondIndex;
        for (secondIndex = 0; secondIndex < nums.length; secondIndex++) {
            if (nums[secondIndex] != val) {
                nums[firstIndex++] = nums[secondIndex];
            }
        }
        return firstIndex;
    }
}
