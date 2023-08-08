package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-08 13:15
 */
public class algorithm_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums = new int[m+n];
        int oneIndex = 0;
        int twoIndex = 0;
        int temp = 0;
        while(oneIndex < m || twoIndex < n) {
            if (oneIndex >= m) {
                nums[temp++] = nums2[twoIndex++];
            } else if (twoIndex >= n) {
                nums[temp++] = nums1[oneIndex++];
            } else if (nums1[oneIndex] >= nums2[twoIndex]) {
                nums[temp++] = nums2[twoIndex++];
            } else if (nums2[twoIndex] > nums1[oneIndex]){
                nums[temp++] = nums1[oneIndex++];
            }
        }
        System.arraycopy(nums, 0, nums1, 0, m+n);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int oneIndex = m-1;
        int twoIndex = n-1;
        int temp = m+n-1;
        while(oneIndex >= 0 || twoIndex >= 0) {

            if (oneIndex < 0) {
                nums1[temp--] = nums2[twoIndex--];
            } else if (twoIndex < 0) {
                nums1[temp--] = nums1[oneIndex--];
            } else if (nums1[oneIndex] >= nums2[twoIndex]) {
                nums1[temp--] = nums1[oneIndex--];
            } else if (nums2[twoIndex] > nums1[oneIndex]) {
                nums1[temp--] = nums2[twoIndex--];
            }
        }
    }
}
