package com.prectice.leetcode_100_review1.tan_xin;

/**
 * @author JLS
 * @description:
 * @since 2024-06-21 10:58
 */
public class algorithm_45 {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int index = 0;
        int number = 0;
        while (index < nums.length) {
            int more = 0;
            int temp = index;
            if (index+nums[index] >= nums.length-1) {
                return ++number;
            }
            for (int i = index+1; i <= index+nums[index]; i++) {
                if (i+nums[i]-index-nums[index] > more) {
                    more = i+nums[i]-index-nums[index];
                    temp = i;
                }
            }
            number++;
            index = temp;
        }
        return number;

    }
}
