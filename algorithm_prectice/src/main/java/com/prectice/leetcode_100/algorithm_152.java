package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-12-22 12:14
 */
public class algorithm_152 {
    public int maxProduct(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int max = -11;
        dp[0] = nums[0];
        int flagLeft = -1;
        int flagRight = -1;
        if (nums[0] < 0) {
            flagLeft = 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (dp[i-1] != 0) {
                    dp[i] = dp[i - 1] * nums[i];
                    if (flagLeft < 0 && nums[i] < 0) {
                        flagLeft = i;
                    } else if (nums[i] < 0) {
                        flagRight = i;
                    }
                } else {
                    dp[i] = nums[i];
                    if (flagLeft < 0 && nums[i] < 0) {
                        flagLeft = i;
                    }
                }
            } else if (nums[i] == 0) {
                dp[i] = 0;
                if (dp[i-1] >= 0) {
                    max = Math.max(dp[i-1], max);
                } else {
                    if (flagRight > -1) {
                        max = Math.max(max, dp[flagRight-1]);
                        max = Math.max(max, dp[i-1] / dp[flagLeft]);
                    } else {
                        max = Math.max(max, i-1 == flagLeft ? 0 : dp[i-1] / dp[flagLeft]);
                        if (flagLeft > 0) {
                            max = Math.max(max, dp[flagLeft - 1]);
                        }
                    }
                }
                flagLeft = -1;
                flagRight = -1;
            }
        }

        if (dp[nums.length-1] >= 0) {
            max = Math.max(max, dp[nums.length-1]);
        } else {
            if (flagRight > -1) {
                max = Math.max(max, dp[flagRight-1]);
                max = Math.max(max, dp[nums.length-1] / dp[flagLeft]);
            } else {
                max = Math.max(max, nums.length-1 == flagLeft ? 0 :dp[nums.length-1] / dp[flagLeft]);
                if (flagLeft > 0) {
                    max = Math.max(max, dp[flagLeft - 1]);
                }
            }
        }

        return max;

    }

    public int maxProduct1(int[] nums) {
        int tampMax = 1;
        int tampMin = 1;
        int max = -11;
        for (int i : nums) {
            if (i < 0) {
                int temp = tampMax;
                tampMax = tampMin;
                tampMin = temp;
            }
            tampMax = Math.max(i, tampMax*i);
            tampMin = Math.min(i, tampMin*i);
            max = Math.max(tampMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        algorithm_152 algorithm152 = new algorithm_152();
        int[] nums = new int[]{-2,0,-1};
        System.out.println(algorithm152.maxProduct(nums));
    }

}
