package com.geekuniversity.algorithm.homework.week1;

/**
 * 接雨水
 * Leetcode地址：https://leetcode-cn.com/problems/trapping-rain-water
 */
public class RainTrap {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            int maxRight = 0;
            for (int j = i + 1; j <= height.length - 1; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            int minHeight = Math.min(maxLeft, maxRight);
            if (minHeight > height[i]) {
                sum = sum + (minHeight - height[i]);
            }
        }
        return sum;
    }

}