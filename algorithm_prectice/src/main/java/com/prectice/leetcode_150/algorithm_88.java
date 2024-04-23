package com.prectice.leetcode_150;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2024-03-25 11:17
 */
public class algorithm_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp = m + n - 1;
        int index1 = m-1;
        int index2 = n-1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[temp--] = nums2[index2--];
                continue;
            }
            if (index2 < 0) {
                nums1[temp--] = nums1[index1--];
                continue;
            }

            if (nums1[index1] < nums2[index2]) {
                nums1[temp--] = nums2[index2--];

            } else {
                nums1[temp--] = nums1[index1--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        algorithm_88 algorithm88 = new algorithm_88();
        algorithm88.merge(nums1, 3, nums2, 3);
    }
}
