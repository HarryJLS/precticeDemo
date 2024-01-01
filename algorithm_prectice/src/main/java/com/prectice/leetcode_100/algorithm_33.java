package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-05 12:44
 */
public class algorithm_33 {

    int result = -1;
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        test(nums, 0, nums.length-1, target);
        return result;

    }

    private void test(int[] nums, int left, int right, int target) {
        if (left >= right) {
            if (nums[left] == target) {
                result = left;
            }
            return;
        }

        int mid = (left + right)/2;
        if (nums[mid] == target) {
            result = mid;
            return;
        } else if (nums[mid] < target) {
            if (nums[mid] <= nums[right]) {
                if (nums[right] < target) {
                    test(nums, left, mid-1, target);
                } else {
                    test(nums, mid+1, right, target);
                }
            } else {
                test(nums, mid+1, right, target);
            }
        } else {
            if (nums[mid] >= nums[left]) {
                if (nums[left] > target) {
                    test(nums, mid+1, right, target);
                } else {
                    test(nums, left, mid-1, target);
                }
            }else {
                test(nums, left,mid-1, target);
            }

        }
    }

    public static void main(String[] args) {
        int[] demo = new int[]{4,5,6,7,0,1,2};
        algorithm_33 algorithm33 = new algorithm_33();
        System.out.println(algorithm33.search(demo, 0));
    }
}
