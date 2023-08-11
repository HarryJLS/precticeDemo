package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-10 12:38
 */
public class algorithm_674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int startIndex = 0;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                startIndex = i;
            }
            result = Math.max(result, i-startIndex+1);
        }
        return result;

    }
}
