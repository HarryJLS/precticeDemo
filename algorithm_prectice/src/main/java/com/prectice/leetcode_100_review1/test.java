package com.prectice.leetcode_100_review1;

import com.prectice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author JLS
 * @description:
 * @since 2024-07-24 20:13
 */
public class test {


    public int longestValidParentheses(String s) {
        int[] nums = new int[s.length()];
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            int j = i-1- nums[i-1];
            if (j >= 0 && s.charAt(j) == '(') {
                nums[i] = nums[i-1] + 2;
                nums[j] = nums[i];
                if (j-1 >= 0 && nums[j-1] > 0) {
                    nums[i] += nums[j-1];
                    nums[j] = nums[i];
                }
            }
            result = Math.max(result, nums[i]);

        }
        return result;
    }

}
