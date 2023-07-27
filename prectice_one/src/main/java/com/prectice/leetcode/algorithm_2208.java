package com.prectice.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author JLS
 * @description:
 * @since 2023-07-25 13:03
 */
public class algorithm_2208 {

    public int halveArray(int[] nums) {

        PriorityQueue<Double> maxQueue = new PriorityQueue<>((e1, e2)-> (e2 -e1 > 0 ? 1 : -1));
        double sum = 0;
        for (int number : nums) {
            sum += number;
            maxQueue.offer((double) number);
        }
        double target = sum / 2.0;
        int flagNumber = 0;
        while (sum > target) {
            double temp = maxQueue.poll()/2;
            sum -= temp;
            maxQueue.offer(temp);
            flagNumber++;
        }


        return flagNumber;

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((e1, e2)-> (e2 -e1 > 0 ? 1 : -1));
        maxQueue.offer(1);
        maxQueue.offer(6);
        maxQueue.offer(5);
        maxQueue.offer(2);
        System.out.println(maxQueue.poll());
    }
}
