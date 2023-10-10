package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-09-22 12:51
 */
public class algorithm_56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> resultList = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp = new int[]{Math.min(temp[0], intervals[i][0]), Math.max(temp[1], intervals[i][1])};
            } else {
                resultList.add(new int[]{temp[0], temp[1]});
                temp = intervals[i];
            }
        }
        resultList.add(new int[]{temp[0], temp[1]});
        int[][] resultData = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            resultData[i] = resultList.get(i);
        }
        return resultData;
    }
}
