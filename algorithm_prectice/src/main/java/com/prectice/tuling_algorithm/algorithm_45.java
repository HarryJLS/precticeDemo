package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-12-18 13:04
 */
public class algorithm_45 {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int number = 0;
        int index = 0;
        while (index < nums.length) {
            int vaild = 0;
            int temp = 0;
            if (index + nums[index] >= nums.length-1) {
                return ++number;
            }
            for (int i = index + 1; i <= index + nums[index]; i++) {
                if (i + nums[i] - index - nums[index] > vaild) {
                    temp = i;
                    vaild = i + nums[i] - index - nums[index];
                }
            }
            number++;
            index = temp;
        }
        return number;
    }
}
