package com.prectice.leetcode_100_review1.ji_qiao;

/**
 * @author JLS
 * @description: 技巧类
 * @since 2024-05-07 10:04
 */
public class algorithm_75 {

    public void sortColors(int[] nums) {
        int index0 = 0;
        int index1 = 0;
        int index2 = 0;
        for (int num : nums) {
            if (num == 0) {
                nums[index2++] = 2;
                nums[index1++] = 1;
                nums[index0++] = 0;
            } else if (num == 1) {
                nums[index2++] = 2;
                nums[index1++] = 1;

            } else if (num == 2) {
                nums[index2++] = 2;
            }
        }
    }
}
