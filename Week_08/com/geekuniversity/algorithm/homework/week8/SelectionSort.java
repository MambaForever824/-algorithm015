package com.geekuniversity.algorithm.homework.week8;

/**
 * 选择排序（https://leetcode-cn.com/problems/sort-an-array/）
 * 每次找最小值，然后放到【待排序】数组的起始位置，一次排序，【待排序的数组】第一个值一定是最小值
 */
public class SelectionSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

}