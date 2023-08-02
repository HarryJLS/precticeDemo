package com.prectice.leetcode;

import java.util.Arrays;

/**
 * @author JLS
 * @description:
 * @since 2023-07-10 14:38
 */
public class algorithm_16 {

    public static int threeSumClosest(int[] nums, int target) {

        // 先对数组进行排序
        Arrays.sort(nums);
        // 计算出数组中的最大值和最小值
        int min = nums[0] + nums[1] + nums[2];
        int length = nums.length;
        int max = nums[length - 1] + nums[length - 2] + nums[length -3];
        // 对于三种特殊情况进行特别处理
        if (min >= target) return min;
        if (max <= target) return max;
        if (nums.length == 3) return min;
        // 中间值，用于保存计算过程中的和值
        int temp = min;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] + nums[i+1] + nums[i+2] -target > Math.abs(temp - target)) return temp;

            // 定义左右两边指针
            int left = i + 1;
            int right = length - 1;
            // 定义循坏条件
            while (left < right) {
                // 计算出初始的和值
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return target;

                // 当初始和值大于target值时，则动右边的指针来获取大于target的最小值
                if (sum > target) {
                    int t = nums[i] + nums[left];

                    while (left < right && sum > target) {
                        right--;
                        sum = t + nums[right];

                    }
                    sum = t + nums[right + 1];
                    if (sum - target < Math.abs(temp - target)) temp = sum;

                } else {
                    int t = nums[i] + nums[right];
                    while (left < right && target > sum) {
                        left++;
                        sum = t + nums[left];
                    }
                    sum = t + nums[left - 1];
                    if (target - sum < Math.abs(temp - target)) temp = sum;
                }
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{147,465,-917,-321,551,982,-967,-672,670,-859,-776,290,-406,223,123,-266,730,339,792,588,138,822,474,-615,386,-392,559,364,124,829,-505,553,-284,-458,-826,-791,-67,-798,932,-828,-739,65,-782,-159,363,-123,893,-992,-662,-65,-352,-649,-357,780,-690,-584,-660,-427,802,113,856,34,-145,-97,-8,488,467,-24,967,96,-915,309,-931,989,-789,886,-568,451,965,-344,917,-994,865,-537,241,-761,812,768,648,594,-702,-640,845,350,-408,984,870,246,-107,508,-860,-298,514,349,960,-663,-616,-87,566,-449,161,522,293,270,-276,928,-612,117,-263,721,-692,-712,995,729,115,463,328,397,-781,-253,782,-542,71,919,286,-732,-271,401,-820,51,-232,-170,-189,154,-487,-221,632,860,38,-224,839,-227,656,194,-331,-422,-997,784,640,-367,385,202,520,-553,-44,208};
        System.out.println(threeSumClosest(nums, 1826));
    }
}
