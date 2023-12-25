package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-18 12:31
 */
public class algorithm_55 {

    public boolean canJump(int[] nums) {

        int length = nums.length;
        for (int i = length-2; i >= 0; i--) {
            if (nums[i] > 0) {
                continue;
            } else {
                boolean flag = false;
                for (int j = i -1; j >= 0; j--) {
                    if (nums[j] > i - j) {
                        flag = true;
                        i= j;
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }
}
