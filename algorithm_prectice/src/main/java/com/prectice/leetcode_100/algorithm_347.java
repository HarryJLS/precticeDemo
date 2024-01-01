package com.prectice.leetcode_100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author JLS
 * @description:
 * @since 2023-12-13 13:11
 */
public class algorithm_347 {

    public int[] topKFrequent(int[] nums, int k) {

        Comparator<test> sumCompare = Comparator.comparingInt(test::getSum).reversed();
        PriorityQueue<test> maxHeap = new PriorityQueue<>((e1, e2) -> (e2.getSum() - e1.getSum() > 0 ? 1 : -1));

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(new test(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getNumber();
        }
        return result;

    }

    class test {
        int number;
        int sum;
        public test(int number, int sum) {
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

    public static void main(String[] args) {
        // e1子元素（新元素） e2父元素
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((e1, e2) -> (e1 -e2 > 0 ? 1 : -1));// 小顶堆
        PriorityQueue<Integer> queue2 = new PriorityQueue<>((e1, e2) -> (e2 - e1 > 0 ? 1 : -1));// 大顶堆
        queue2.offer(1);
        queue2.offer(2);
        queue2.offer(0);
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(0);
        System.out.println(queue1.peek());
        System.out.println(queue2.peek());

    }

}
