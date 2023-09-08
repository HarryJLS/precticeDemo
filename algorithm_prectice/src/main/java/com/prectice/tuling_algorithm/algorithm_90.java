package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-09-01 12:57
 */
public class algorithm_90 {

    public int rob(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(countMax(nums, 0, length-2), countMax(nums, 1, length-1));

    }

    private int countMax(int[] nums, int index) {
        if (nums == null || index < 0) {
            return 0;
        }
        if (index == 0) {
            return nums[0];
        }
        return Math.max(countMax(nums, index-1), nums[index] + countMax(nums, index-2));
    }

    private int rob2(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int temp = 0;
        for (int i = 2; i < length; i++) {
            temp = Math.max(second, nums[i] + first);
            first = second;
            second = temp;
        }
        return second;
    }

    private int countMax(int[] nums, int start, int end) {

        int first = nums[start];
        int second = Math.max(nums[start], nums[start+1]);
        int temp = 0;
        for (int i = start+2; i <= end; i++) {
            temp = Math.max(second, nums[i] + first);
            first = second;
            second = temp;
        }
        return second;
    }
}
