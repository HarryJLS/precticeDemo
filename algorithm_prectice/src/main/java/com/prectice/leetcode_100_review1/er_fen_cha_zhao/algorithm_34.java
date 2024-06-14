package com.prectice.leetcode_100_review1.er_fen_cha_zhao;

/**
 * @author JLS
 * @description:
 * @since 2024-06-13 10:24
 */
public class algorithm_34 {

    int[] result = new int[]{-1, -1};
    public int[] searchRange(int[] nums, int target) {

        reverse(nums, target, 0, nums.length-1);
        return result;

    }

    private void reverse(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }
        int mid = (startIndex + endIndex) / 2;
        if (nums[mid] == target) {
            search(nums, target, mid);
        } else if (nums[mid] > target) {
            reverse(nums, target, startIndex, mid - 1);
        } else {
            reverse(nums, target, mid+1, endIndex);
        }
    }

    private void search(int[] nums, int target, int mid) {
        int left = mid;
        while (left >= 0) {
            if(nums[left] == target) {
                result[0] = left;
                left--;
            } else {
                break;
            }
        }
        int right = mid;
        while (right < nums.length) {
            if (nums[right] == target) {
                result[1] = right;
                right++;
            } else {
                break;
            }
        }

    }
}
