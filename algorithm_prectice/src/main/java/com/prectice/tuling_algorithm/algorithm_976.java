package com.prectice.tuling_algorithm;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2023-08-10 13:00
 */
public class algorithm_976 {
    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        for (int i = nums.length-1; i >=2; i--) {
            if (nums[i] < nums[i-1] + nums[i-2]) {
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }
}
