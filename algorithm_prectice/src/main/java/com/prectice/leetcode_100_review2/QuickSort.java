package com.prectice.leetcode_100_review2;

import com.alibaba.fastjson.JSON;

/**
 * @author Jiangls
 * @description:
 * @since 2025-07-23 09:55
 */
public class QuickSort {

    public int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = left;
        for (int i = left; i < right ; i++) {
            if (nums[i] <= nums[right]) {
                if (i != index) {
                    swap(nums, i, index);
                }
                index++;
            }
        }
        swap(nums, index, right);
        if (left < index) {
            quickSort(nums, left, index - 1);
        }
        if (index < right) {
            quickSort(nums, index + 1, right);
        }

    }
    private void swap(int[] nums, int index1, int index2) {
        int temp= nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] sort = quickSort.sort(new int[]{1, 4, 6, 2, 4});
        System.out.println(JSON.toJSONString(sort));
    }
}
