package com.prectice.leetcode_100_review2.动态规划2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-18 10:34
 */
public class algorithm_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> integers = resultList.get(i - 1);
                    list.add(integers.get(j-1) + integers.get(j));
                }
            }
            resultList.add(list);
        }
        return resultList;
    }
}
