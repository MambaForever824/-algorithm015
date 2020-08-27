package com.geekuniversity.algorithm.homework.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那【两个】整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 解题思路：
 * 1、暴力解法
 * 双层循环，遍历所有元素，发现两个值相加==target时，返回元素下标
 * 时间复杂度为O(N*N），其中N为数组长度
 *
 * 2、借用Map，存储已遍历的元素和下标
 * 时间复杂度O(N)
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 暴力求解
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
