package com.prectice.leetcode_100_review1.pu_tong_shu_zu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-05-20 11:19
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
                list.add(temp);
                temp = intervals[i];
            }
        }
        list.add(temp);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;


    }
}
