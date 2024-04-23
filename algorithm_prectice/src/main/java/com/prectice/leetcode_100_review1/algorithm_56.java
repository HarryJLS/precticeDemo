package com.prectice.leetcode_100_review1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-04-02 17:04
 */
public class algorithm_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp = new int[]{Math.min(temp[0], intervals[i][0]), Math.max(temp[1], intervals[i][1])};
            } else {
                list.add(new int[]{temp[0], temp[1]});
                temp = intervals[i];
            }
        }
        list.add(temp);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
