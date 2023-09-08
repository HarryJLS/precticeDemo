package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-24 12:30
 */
public class algorithm_799 {

    /**
     * 解题思路： 主要是理解题目意思，然后进行个代码模拟
     * 倒香槟，倒满之后即向两端溢出，每一杯计算溢出前的总量，然后计算要溢出量，通过计算相邻的两倍应该接受的量，
     * 然后计算之后的香槟量，自己管自己计算就行，然后每个元素是进行累加，而不是赋值，通过得到最后的累加量来得出最后的答案
     */
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] ca = new double[query_row + 1][query_row + 1];
        ca[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double d = (ca[i][j] - 1.0) / 2.0;
                if (d > 0) {
                    ca[i + 1][j] += d;
                    ca[i + 1][j + 1] += d;
                }

            }

        }
        return ca[query_row][query_glass] > 1 ? 1.0 : ca[query_row][query_glass];
    }
}
