package com.prectice.leetcode_100_review2;

import com.alibaba.fastjson.JSON;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-19 09:35
 */
public class QuickSort1 {

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, right);
        sort(nums, left, index - 1);
        sort(nums, index + 1, right);
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        QuickSort1 quickSort1 = new QuickSort1();
        int[] nums = new int[]{4, 2,1,9,6,7};
        quickSort1.quickSort(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
