package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-04 12:06
 */
public class algorithm_35 {

    int result = -1;
    public int searchInsert(int[] nums, int target) {

        int right = nums.length - 1;
        int left = 0;
        if (target > nums[right]) {
            return right + 1;
        } else if (target < nums[left]) {
            return 0;
        }
        test(nums, 0, right, target);
        return result;
    }

    private void test(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] == target) {
                result = left;
            } else if (nums[left] > target) {
                result = left;
            } else if (nums[left] < target){
                result = left + 1;
            }
            return;
        }

        int mid = (left + right)/2;
        if (nums[mid] == target) {
            result = mid;
            return;
        }
        if (mid < right && target > nums[mid]) {
            if (nums[mid + 1] > target) {
                result = mid + 1;
                return;
            }
            test(nums, mid+1, right, target);
        }
        if (mid > left && target < nums[mid]) {
            if (nums[mid - 1] < target) {
                result = mid;
                return;
            }
            test(nums, left, mid -1, target);
        }
    }

    public static void main(String[] args) {
        algorithm_35 algorithm35 = new algorithm_35();
        int[] nums = new int[]{3,5,7,9,10};
        System.out.println(algorithm35.searchInsert(nums, 8));

    }
}
