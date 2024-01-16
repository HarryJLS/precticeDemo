package com.prectice.leetcode_100;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2024-01-16 12:02
 */
public class algorithm_287 {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                return nums[left];
            }
            left++;
            right++;
        }
        return 0;
    }

    // 可以抽象为环形链表，找环的交点
    public int findDuplicate1(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                fast = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
}
