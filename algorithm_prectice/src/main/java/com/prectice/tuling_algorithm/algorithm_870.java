package com.prectice.tuling_algorithm;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2023-09-08 13:08
 */
public class algorithm_870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] copyNums2 = nums2.clone();
        Arrays.sort(nums1);
        Arrays.sort(copyNums2);
        Map<Integer, Deque<Integer>> queMap = new HashMap<>();
        for (int i : nums2) {
            queMap.put(i, new LinkedList<>());
        }
        Deque<Integer> otherDeque = new LinkedList<>();
        int j = 0;
        for (int i : nums1) {
            if (i > copyNums2[j]) {
                queMap.get(copyNums2[j]).add(i);
                j++;
            } else {
                otherDeque.add(i);
            }

        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (!queMap.get(nums2[i]).isEmpty()) {
                result[i] = queMap.get(nums2[i]).removeLast();
            } else {
                result[i] = otherDeque.removeLast();
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{12,24,8,32};

    }

}
