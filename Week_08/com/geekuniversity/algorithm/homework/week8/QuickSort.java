package com.geekuniversity.algorithm.homework.week8;

/**
 * 快速排序（https://leetcode-cn.com/problems/sort-an-array/）
 * 数组取标杆pivot，将小元素放pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排；
 * 以达到整个序列有序；采用【分治】+【递归】的思想；
 */
public class QuickSort {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(nums, begin, end);
        quickSort(nums, 0, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }
}