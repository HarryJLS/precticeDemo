package com.prectice.leetcode_100_review2.动态规划;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiangls
 * @description:
 * @since 2025-08-12 19:37
 */
public class algorithm_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                resultList.add(Arrays.asList(1));
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                List<Integer> integers = resultList.get(i-1);
                if (j == 0) {
                    temp.add(1);
                    continue;
                }
                if (j == i) {
                    temp.add(1);
                    continue;
                }
                temp.add(integers.get(j-1) + integers.get(j));
            }
            resultList.add(temp);
        }
        return resultList;
    }
}
