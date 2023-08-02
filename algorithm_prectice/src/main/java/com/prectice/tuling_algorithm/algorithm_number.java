package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-07-31 12:53
 */
public class algorithm_number {

    public static int bf (int n) {
        if (n < 2) {
            return 0;
        }
        int result = 1;
        boolean flag = true;
        for (int number = 3; number <= n; number += 2) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) {
                result++;
            }
        }
        return result;
    }

    // 埃筛法
    public static int asf(int n) {
        boolean[] nums = new boolean[n+1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!nums[i]) {
                count++;
                for (int j = 2 * i; j <= n; j +=i) {
                    nums[j] = true;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(asf(101));
    }


}
