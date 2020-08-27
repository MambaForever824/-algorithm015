package com.geekuniversity.algorithm.homework.week1;

/**
 * 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 解题思路：
 * 1、暴力解法
 * 将数组nums2全部复制到num1后，然后使用【排序算法】进行排序
 * 时间复杂度 与 排序算法 保持一致
 *
 * 2、双指针
 * 定义两个指针，分布指向 两个数组 最后的元素，因为数组有序，只要从后往前比较两个数组的较大值，大的插入数组后面
 * 依次比较，直到遍历完
 */
public class ArrayMerge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int len1 = m;
        int len2 = n;
        while (len1 > 0 && len2 > 0) {
            int val = Math.max(nums1[len1 - 1], nums2[len2 - 1]);
            nums1[index--] = val;
            if (nums1[len1 - 1] > nums2[len2 - 1]) {
                len1--;
            } else {
                len2--;
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, len2);
    }
}