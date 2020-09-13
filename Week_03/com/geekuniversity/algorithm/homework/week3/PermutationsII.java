package com.geekuniversity.algorithm.homework.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * Leetcode: https://leetcode-cn.com/problems/permutations-ii/
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        int length = nums.length;
        List<Integer> path = new ArrayList(length);
        boolean[] used = new boolean[length];
        dfs(nums, length, results, path, 0, used);
        return results;
    }

    private void dfs(int[] nums,
                     int length,
                     List<List<Integer>> results,
                     List<Integer> path,
                     int index,
                     boolean[] used) {
        if (path.size() == length) {
            results.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, length, results, path, i + 1, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}