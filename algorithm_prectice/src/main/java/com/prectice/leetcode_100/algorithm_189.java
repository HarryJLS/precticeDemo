package com.prectice.leetcode_100;

import java.util.LinkedList;

/**
 * @author JLS
 * @description:
 * @since 2023-09-25 12:15
 */
public class algorithm_189 {

    public void rotate(int[] nums, int k) {

        if (k > nums.length) {
            k = k % nums.length;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for(int i : nums) {
            list.addLast(i);
        }
        for (int i = 0; i < k; i++) {
            Integer integer = list.removeLast();
            list.addFirst(integer);
        }
        int index = 0;
        while (!list.isEmpty()) {
            nums[index++] = list.removeFirst();
        }
    }

    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        if (k > length) {
            k = k % length;
        }
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[length - k + i];
        }
        for (int i = length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }






    }

    public static void main(String[] args) {
        algorithm_189 algorithm189 = new algorithm_189();
        algorithm189.rotate(new int[]{1,2,3,4,5,6, 7}, 3);
    }
}
