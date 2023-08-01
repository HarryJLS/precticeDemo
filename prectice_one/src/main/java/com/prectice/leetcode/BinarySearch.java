package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-29 15:48
 */
public class BinarySearch {

    public static void test(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            System.out.println("数据为空");
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                System.out.println("所在位置在：" + 0);
            } else {
                System.out.println("无所要数据");
            }
        }

        System.out.println("位置在：  " + search(nums, 0, nums.length - 1, target));


    }

    public static int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return 99;
        }
        if (left + 1 == right && nums[left] != target && nums[right] != target) {
            return 99;
        }
        int midIndex = (right + left) / 2;
        if (nums[midIndex] == target) {
            return midIndex;
        } else if (nums[midIndex] > target) {
            return search(nums, left, midIndex, target);
        } else {
            return search(nums, midIndex, right, target);
        }
    }

    public static void test1(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            System.out.println("数据为空");
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                System.out.println("所在位置在：" + 0);
            } else {
                System.out.println("无所要数据");
            }
        }

        System.out.println("位置在： " + search(nums, target));
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            if (left + 1 == right && nums[left] != target && nums[right] != target) {
                return 99;
            }

            int midIndex = (left + right)/2;
            if (nums[midIndex] == target) {
                return midIndex;
            } else {
                if (nums[midIndex] > target) {
                    right = midIndex - 1;
                } else {
                    left = midIndex + 1;
                }
            }
        }
        return 99;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,56,78,456,8451,5616156};
        test1(nums, 8451);
    }
}
