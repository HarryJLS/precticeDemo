package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-07-31 13:31
 */
public class algorithm_deleteDuplate {

    public static int deleteDuplate(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,5,5,5,6};
        System.out.println(deleteDuplate(nums));
    }
}
