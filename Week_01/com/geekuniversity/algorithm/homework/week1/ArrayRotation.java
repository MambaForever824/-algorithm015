/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 说明:
 * (1) 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * (2) 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 解题思路：
 * 解法一
 * 暴力解法，将整个数组移动k次，每次只移动一个元素
 * 时间复杂度是 O(n*k)，空间复杂度为O(1)
 *
 * 解法二
 * 首先想到的方法就是新建一个长度为n（n为数组长度）的数组array；
 * nums中下标为i的元素，放入array的(i+k)%n
 * 但不满足空间复杂度为O(1)的要求
 *
 * 解法三
 * 看了LeetCode题解，先把整个元素反转，在分别反转前k个，和n-k的元素
 * 当 k > 数组长度，这个方法会出现数组越界
 * 时间复杂度为O(n)，空间复杂度为O(1)
 */
package com.geekuniversity.algorithm.homework.week1;

public class ArrayRotation {

    /**
     * 遍历k次，每次移动一个元素
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            // 每次取数组最后一个元素
            int prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }

    /**
     * 先反转整个数组，再分别反转前k位 和 n-k 位
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        reserve(nums, 0 , nums.length - 1);
        reserve(nums, 0, k - 1);
        reserve(nums, k, nums.length - 1);
    }

    private void reserve(int[] nums, int start, int end) {
        while (start < end) {
            int val0 = nums[start];
            int val1 = nums[end];
            nums[start] = val1;
            nums[end] = val0;
            start++;
            end--;
        }
    }
}
