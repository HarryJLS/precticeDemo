package com.prectice.tuling_algorithm;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2023-08-02 13:08
 */
public class algorithm_628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[0]*nums[1]*nums[length-1], nums[length-1]*nums[length-2]*nums[length-3]);
    }

    public int maximumProduct1(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        return Math.max(max1 * min1 * min2, max1 * max2 * max3);
    }
}
