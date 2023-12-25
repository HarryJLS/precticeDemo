package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-05 12:17
 */
public class algorithm_34 {

    int[] result = new int[] { -1, -1 };

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] > target || nums[right] < target) {
            return result;
        }
        test(nums, left, right, target);
        return result;

    }

    private void test(int[] nums, int left, int right, int target) {
        if (left >= right) {
            if (nums[left] != target) {
                result = new int[] { -1, -1 };
                return;
            } else {
                while (left >= 0 && right < nums.length) {
                    if (left > 0 && nums[left - 1] == target) {
                        left--;
                        continue;
                    }
                    if (right < nums.length-1 && nums[right + 1] == target) {
                        right++;
                        continue;
                    }
                    result = new int[] { left, right };
                    break;
                }
            }
            return;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            test(nums, mid, mid, target);
        } else if (nums[mid] < target) {
            test(nums, mid + 1, right, target);
        } else {
            test(nums, left, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] demo = new int[]{0, 1, 1, 2};
        algorithm_34 algorithm34 = new algorithm_34();
        algorithm34.searchRange(demo, 1);
    }
}
