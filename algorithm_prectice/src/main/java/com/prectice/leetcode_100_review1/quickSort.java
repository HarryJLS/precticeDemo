package com.prectice.leetcode_100_review1;

/**
 * @author JLS
 * @description:
 * @since 2024-04-01 10:50
 */
public class quickSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        quicksort(nums, 0, nums.length - 1);
    }
    public void quicksort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }
        int index = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < nums[right]) {
                if (index != i) {
                    swap(nums, i, index);
                    index++;
                } else {
                    index++;
                }
            }
        }
        swap(nums, index, right);
        if (left < index) {
            quicksort(nums, left, index-1);
        }
        if (index < right) {
            quicksort(nums, index+1 , right);
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        quickSort quickSort = new quickSort();
        int[] nums = new int[]{1,5,2,9,8,4,2,1};
        quickSort.sort(nums);
        System.out.println("执行成功");
    }
}
