package com.geekuniversity.algorithm.homework.week4;

import java.util.LinkedList;
import java.util.List;

/**
 * 生成括号
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 通过深度优先算法记录每个括号
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> results = new LinkedList<>();
        if (n <= 0) {
            return results;
        }
        generate(n, 0, 0, results, "");
        return results;
    }

    private void generate(int n, int left, int right, List<String> results, String path) {
        if (left == n && right == n) {
            results.add(path);
            return;
        }
        if (left < n) {
            generate(n, left + 1, right, results, path + "(");
        }
        if (right < left) {
            generate(n, left, right + 1, results, path + ")");
        }
    }

}