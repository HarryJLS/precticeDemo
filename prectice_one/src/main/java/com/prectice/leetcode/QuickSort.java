package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-28 11:21
 */
public class QuickSort {

    public static int[] sort(int[] nums) {

        if (nums == null || nums.length == 0)
            return new int[] {};

        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int flag = left;

        for (int i = left; i < right; i++) {
            if (nums[i] <= nums[right]) {
                if (flag != i) {
                    swap(nums, flag, i);
                    flag++;
                } else {
                    flag++;
                }
            }
        }
        swap(nums, flag, right);
        if (left < flag) {
            quickSort(nums, left, flag - 1);
        }
        if (flag < right) {
            quickSort(nums, flag + 1, right);
        }
    }

    /**
     * 数据位置互换方法
     */
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 5, 1, 3, 9, 56, 78, 131, 1, 3, 6, 9, 78, 42, 5 };
        sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
