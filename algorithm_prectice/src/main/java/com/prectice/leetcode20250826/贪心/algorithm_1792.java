package com.prectice.leetcode20250826.贪心;

import java.util.PriorityQueue;

/**
 * @author JLS
 * @description: 最大平均通过率
 * @since 2025-09-01 15:18
 */
public class algorithm_1792 {

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            float anum = (float)(a[0] + 1) / (float)(a[1] + 1) - (float)a[0] / (float)a[1];
            float bnum = (float)(b[0] + 1) / (float)(b[1] + 1) - (float)b[0] / (float)b[1];
                if (anum == bnum) {
                return 0;
            }
            return anum > bnum ? -1 : 1;
        });
        for (int i = 0; i < classes.length; i++) {
            queue.offer(classes[i]);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] poll = queue.poll();
            poll[0]++;
            poll[1]++;
            queue.offer(poll);
        }
        double sum = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            sum += (double)poll[0]/poll[1];
        }
        return sum / classes.length;
    }

    public static void main(String[] args) {
        System.out.println(maxAverageRatio(new int[][]{new int[]{1, 2}, new int[]{3,5}, new int[]{2, 2}}, 2));
    }
}
