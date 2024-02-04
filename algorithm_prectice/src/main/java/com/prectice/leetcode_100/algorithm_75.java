package com.prectice.leetcode_100;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2024-01-15 12:25
 */
public class algorithm_75 {

    public void sortColors(int[] nums) {

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for (int i : nums) {
            if (i == 0) {
                nums[index3++] = 2;
                nums[index2++] = 1;
                nums[index1++] = 0;
            } else if (i == 1) {
                nums[index3++] = 2;
                nums[index2++] = 1;
            } else {
                nums[index3++] = 2;
            }
        }
    }

}
