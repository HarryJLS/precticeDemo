package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-07 12:43
 */
public class algorithm_441 {
    public int arrangeCoins(int n) {
        int sqrt = (int) Math.sqrt(2.0d * n);
        if (sqrt * (sqrt+1) > 2 * n) {
            return sqrt - 1;
        } else {
            return sqrt;
        }
    }

    public int arrangeCoins1(int n) {
        for (int i = 1; i <= n; i++) {
            n -= i;
            if (n <= i) {
                return i;
            }
        }
        return 0;
    }


    public int arrangeCoins2(int n) {
        long low = 0,high = n;
        while (low <= high) {
            long mid = (high - low)/2 + low;
            if (mid*(mid+1)> 2*n) {
                high = mid - 1;
            } else if (mid*(mid+1) == 2 * n) {
                return (int)mid;
            } else {
                low = mid + 1;
            }
        }
        return (int)high;

    }

    public int arrangeCoins3(int n) {
        if (n == 0) {
            return 0;
        }
        return (int) sqrt(n, n);
    }

    private double sqrt(double x, int n)  {
        double res = (x + (2*n - x)/x)/2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res, n);
        }
    }

}
