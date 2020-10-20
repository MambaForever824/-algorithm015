package com.geekuniversity.algorithm.homework.week7;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成(https://leetcode-cn.com/problems/word-ladder/)
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class ParenthesesGeneration {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        generate(n, 0, 0, result, "");
        return result;
    }

    private void generate(int n, int left, int right, List<String> result, String path) {
        if (left == n && right == n) {
            result.add(path);
            return;
        }
        while (left < n) {
            generate(n, left + 1, right, result, path + "(");
        }
        while (right < left) {
            generate(n, left, right + 1, result, path + ")");
        }
    }
}