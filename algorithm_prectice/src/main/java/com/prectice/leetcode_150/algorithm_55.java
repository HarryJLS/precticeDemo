package com.prectice.leetcode_150;

/**
 * @author JLS
 * @description:
 * @since 2024-03-28 09:42
 */
public class algorithm_55 {

    public boolean canJump(int[] nums) {
        boolean flag = true;
        for (int i = nums.length -2; i >= 0; i--) {
            if (nums[i] == 0) {
                if (i > 0 && flag) {
                    for (int j = i - 1; j >= 0; j--) {
                        flag = false;
                        if (nums[j] > i - j) {
                            flag = true;
                            break;
                        }
                    }
                } else {
                    flag = false;
                }

            }
        }

        return flag;
    }
}
