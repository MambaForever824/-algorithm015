package com.geekuniversity.algorithm.homework.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if (n <= 0 || n < k) {
            return results;
        }
        List<Integer> path = new ArrayList<>();
        combine(n, k, results, path, 1);
        return results;
    }

    private void combine(int n,
                         int k,
                         List<List<Integer>> results,
                         List<Integer> path,
                         int curr) {
        if (path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = curr; i <= n; i++) {
            path.add(i);
            combine(n, k, results, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}