package com.geekuniversity.algorithm.homework.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * Leetcode地址：https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 num 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
 *
 *  解题思路：
 * 1、暴力解法，从头到尾变量两次数组，获取数组中不同的值，如果存在则返回
 * 时间复杂度：O(n * n），因为要遍历数组两次
 * 空间复杂度：O(1）
 *
 * 2、使用HashMap，缓存遍历过的数组值，用值作为key，下标作为value，当target - 当前指向的值，在map中存在，则可以返回两个下标
 * 时间复杂度：O(n)，因为只要遍历一次数组
 * 空间复杂度：O(n)，需要额外map存放数组中的值
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSumByMap(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{i, map.get(value)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
