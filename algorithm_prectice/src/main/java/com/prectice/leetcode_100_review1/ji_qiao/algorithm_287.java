package com.prectice.leetcode_100_review1.ji_qiao;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2024-05-08 09:57
 */
public class algorithm_287 {

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return nums[0];
    }

    public int findDuplicate1(int[] nums) {
        int fast = 0;
        int slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                fast = 0;
                while (fast != slow) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return slow;
            }
        }

    }
}
