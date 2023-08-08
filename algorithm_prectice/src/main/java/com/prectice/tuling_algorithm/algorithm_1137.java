package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-04 12:51
 */
public class algorithm_1137 {

    public int tribonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 1;
        }
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }

    public int tribonacci1(int n) {
        int[] nums = new int[40];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        if (n < 3) {
            return nums[n];
        }

        return sum(n-1, n-2, n-3, nums);
    }
    private int sum(int n1, int n2, int n3, int[] nums) {

        if (n1 >= 3) {
            if (nums[n1] == 0) {
                nums[n1] = sum(n1 - 1, n1 - 2, n1 - 3, nums);
            }
        }

        if (n2 >= 3) {
            if (nums[n2] == 0) {
                nums[n2] = sum(n2 - 1, n2 - 2, n2 - 3, nums);
            }
        }
        if (n3 >= 3) {
            if (nums[n3] == 0) {
                nums[n3] = sum(n3 - 1, n3 - 2, n3 - 3, nums);
            }
        }

        return nums[n1] + nums[n2] + nums[n3];


    }

    public int tribonacci2(int n) {
        int low = 0;
        int mid = 1;
        int high = 1;
        if (n == 0)return 0;
        if (n == 1)return 1;
        if (n == 2)return 1;
        int sum = 0;
        for (int i = 0; i < n - 2; i++) {
            sum = low + mid + high;
            low = mid;
            mid = high;
            high = sum;
        }
        return sum;
    }




}
