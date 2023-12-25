package com.prectice.leetcode_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-12-20 12:22
 */
public class algorithm_118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> resultColelction = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i ; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(resultColelction.get(i-1).get(j-1) + resultColelction.get(i-1).get(j));
                }
            }
            resultColelction.add(list);
            
        }
        return resultColelction;
    }
}
