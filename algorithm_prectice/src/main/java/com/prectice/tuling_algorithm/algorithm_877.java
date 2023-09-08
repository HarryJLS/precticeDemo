package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-22 12:29
 */
public class algorithm_877 {

    // 递归的方式
    public boolean stoneGame(int[] piles) {

        int alice = getMaxSum(piles, 0, piles.length-1);
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }

        return 2 * alice > sum;

    }

    private int getMaxSum(int[] piles, int left, int right) {
        if (left == right) {
            return piles[left];
        }
        int leftSum = 0;
        int rightSum = 0;
        if (right - left == 1) {
            leftSum += piles[left];
            rightSum += piles[right];
        }

        if (right - left > 1) {
            leftSum = piles[left] + Math.min(getMaxSum(piles, left + 2, right), getMaxSum(piles, left+1, right-1));
            rightSum = piles[right] + Math.min(getMaxSum(piles, left+1, right-1), getMaxSum(piles, left, right -2));
        }

        return Math.max(leftSum, rightSum);
    }


    /**
     * 核心思想是，计算出两种方案中，对应结果的差值,差值大于0，则说明alice必胜
     *
     * */
    public boolean stoneGame1(int[] piles) {

        int alice = getMaxSum1(piles, 0, piles.length-1);


        return alice > 0;

    }

    private int getMaxSum1(int[] piles, int left, int right) {
        if (left == right) {
            return piles[left];
        }
        int leftSum = piles[left] - getMaxSum1(piles, left + 1, right);
        int rightSum = piles[right] - getMaxSum1(piles, left, right - 1);
        return Math.max(leftSum, rightSum);
    }

    public boolean stoneGame2(int[] piles) {
        return dp(piles);

    }

    /**
     * 动态规划，核心思想是，将left和right两个指针视为数组的两个指标，然后形成二维数组来减少递归中过多的重复计算，也就是把过程所有的可能性的结果都计算一遍
     * */
    private boolean dp(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                dp[i][j] = Math.max(piles[i]-dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }

        return dp[0][length-1]>0;
    }

    private boolean dp2(int[] piles) {
        int length = piles.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                dp[j] = Math.max(piles[i]-dp[j], piles[j] - dp[j-1]);
            }
        }
        return dp[length-1]>0;
    }

}
