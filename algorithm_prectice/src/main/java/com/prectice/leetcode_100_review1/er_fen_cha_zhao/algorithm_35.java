package com.prectice.leetcode_100_review1.er_fen_cha_zhao;

/**
 * @author JLS
 * @description:
 * @since 2024-06-12 15:56
 */
public class algorithm_35 {

    int result  = -1;
    public int searchInsert(int[] nums, int target) {

        reverse(nums, 0, nums.length-1, target);

        return result;
    }

    private void reverse(int[] nums, int startIndex, int endIndex, int target) {
        if (nums[endIndex] < target) {
            result = endIndex+1;
            return;
        } else if (nums[startIndex] > target) {
            result = startIndex;
            return;
        }
        int mid = (startIndex + endIndex)/2;
        if (nums[mid] > target) {
            reverse(nums, startIndex, mid-1, target);
        } else if (nums[mid] < target) {
            reverse(nums, mid+1, endIndex, target);
        } else if (nums[mid] == target) {
            int temp = mid;
            while (temp >= 0 && nums[temp] == target) {
                result = temp;
                temp--;
            }
            return;
        }
    }
}
