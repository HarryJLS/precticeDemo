package com.prectice.leetcode_100_review1.dong_tai_gui_hua;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-06-24 10:51
 */
public class algorithm_118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i) {
                    item.add(1);
                    continue;
                }
                if (i >= 2 && j > 0 && j < i) {
                    item.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(item);
        }
        return result;

    }
}
