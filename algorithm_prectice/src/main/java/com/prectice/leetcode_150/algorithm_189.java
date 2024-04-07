package com.prectice.leetcode_150;

/**
 * @author JLS
 * @description:
 * @since 2024-03-27 10:11
 */
public class algorithm_189 {

    public void rotate(int[] nums, int k) {

        if (k > nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }
        int[] temp = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[i-nums.length+k] = nums[i];
        }
        for (int i = nums.length - k -1 ; i >= 0; i--) {
            nums[i+k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        algorithm_189 algorithm189 = new algorithm_189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        algorithm189.rotate(nums, 3);
    }
}
