package com.geekuniversity.algorithm.homework.week8;

/**
 * 插入排序（https://leetcode-cn.com/problems/sort-an-array/）
 * 【从前到后】逐步构建有序序列，对于【未排序】数据，在【已排序】序列中从后向前扫描，找到响应位置插入；
 */
public class InsertionSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int preIndex = i - 1;
            int curr = nums[i];
            while (preIndex >= 0 && curr < nums[preIndex]) {
                // 关键的步骤，比较之前每一个数，如果当前下标值 小于 之前的某个值，移动
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            // 要把当前值移动到指定下标
            nums[preIndex + 1] = curr;
        }
        return nums;
    }

}