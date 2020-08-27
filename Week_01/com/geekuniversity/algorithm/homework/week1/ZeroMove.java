package com.geekuniversity.algorithm.homework.week1;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 说明:
 *
 * 1、必须在原数组上操作，不能拷贝额外的数组；
 * 2、尽量减少操作次数；
 *
 * 解题思路：
 * 1、暴力解法
 * 新增一个数组，长度和原数组保持一致，遍历nums，将!=0的值放入新数组中，但这违反题目要求
 *
 * 2、双指针法
 * 定义快慢指针，慢指针指向0元素，快指针用于遍历数组
 * 时间复杂度O(N)，只要遍历一次数组
 */
public class ZeroMove {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int zero = nums[slow];
                nums[slow] = nums[i];
                nums[i] = zero;
                slow++;
            }
        }
    }

}