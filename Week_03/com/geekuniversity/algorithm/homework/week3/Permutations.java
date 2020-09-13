package com.geekuniversity.algorithm.homework.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * Leetcode: https://leetcode-cn.com/problems/permutations/
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        int length = nums.length;
        List<Integer> path = new ArrayList<>();
        dfs(nums, length, results, path);
        return results;
    }

    public void dfs(int[] nums,
                    int length,
                    List<List<Integer>> results,
                    List<Integer> path) {
        if (path.size() == length) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, length, results, path);
            path.remove(path.size() - 1);
        }
    }
}