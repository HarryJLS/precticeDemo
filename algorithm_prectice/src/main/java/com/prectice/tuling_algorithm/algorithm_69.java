package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-01 13:13
 */
public class algorithm_69 {

    public int mySqrt(int x) {
        long temp = -1;
        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left)/2;
            if (mid * mid <= x) {
                temp = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)temp;

    }

    public int mySqrt2(int x) {

        if (x == 0) {return 0;}
        return (int)sqrt(x, x);

    }

    private double sqrt(double i, int x) {
        double res = (i + i/x)/2;
        if (res == i) {
            return i;
        } else {
            return sqrt(res, x);
        }
    }


}
