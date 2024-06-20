package com.prectice.leetcode_100_review1.dui;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author JLS
 * @description:
 * @since 2024-06-20 10:14
 */
public class algorithm_347 {

    public int[] topKFrequent(int[] nums, int k) {
        Comparator<test> comparable = Comparator.comparingInt(test::getSum).reversed();
        PriorityQueue<test> queue = new PriorityQueue<>(comparable);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new test(entry.getKey(), entry.getValue()));
        }
        int[] resut = new int[k];
        for (int i = 0; i < k; i++) {
            resut[i] = queue.poll().getNumber();
        }
        return resut;


    }

    class test {
        int number;
        int sum;
        test(int number, int sum) {
            this.number = number;
            this.sum = sum;
        }
        public int getNumber() {
            return number;
        }
        public int getSum() {
            return sum;
        }
    }

}
