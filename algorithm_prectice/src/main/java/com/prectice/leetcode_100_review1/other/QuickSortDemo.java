package com.prectice.leetcode_100_review1.other;

/**
 * @author JLS
 * @description:
 * @since 2024-05-07 11:18
 */
public class QuickSortDemo {

    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quicksort(nums, 0, nums.length -1 );
    }

    private void quicksort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                if (i != index) {
                    swap(nums, i, index);
                    index++;
                } else {
                    index++;
                }
            }
        }
        swap(nums, index, right);
        if (index > left) {
            quicksort(nums, left, index -1);
        }
        if (index < right) {
            quicksort(nums, index+1, right);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        QuickSortDemo quickSortDemo = new QuickSortDemo();
        int[] nums = new int[]{4,4,7,1,3,6,2,9};
        quickSortDemo.sort(nums);
        System.out.println();
    }


}
