package com.prectice.tuling_algorithm;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2023-08-01 12:58
 */
public class algorithm_724 {

    public int pivotIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 0) {
            return 0;
        }
        int sum = Arrays.stream(nums).sum();
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            sumLeft += nums[i];
            if (sumLeft == sum) {
                return i;
            }
            sum -= nums[i];
        }
        return -1;
    }
}
