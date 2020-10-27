package com.geekuniversity.algorithm.homework.week8;

/**
 * 冒泡排序（https://leetcode-cn.com/problems/sort-an-array/）
 * 嵌套循环，每次查看【相邻的】元素如果逆序，则交换，每次把【待排序数组】的最大值放到最后
 */
public class BubbleSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 关键代码，j的最大值每次都往前
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}