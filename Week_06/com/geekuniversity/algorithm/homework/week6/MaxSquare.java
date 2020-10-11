package com.geekuniversity.algorithm.homework.week6;

/**
 * 最大正方形 (https://leetcode-cn.com/problems/maximal-square/)
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class MaxSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows + 1][columns + 1];

        int edge = 0;
        for (int i = 1; i <= rows; i ++) {
            for (int j = 1; j <= columns; j++) {
                 if (matrix[i - 1][j - 1] == '1') {
                     dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                     edge = Math.max(edge, dp[i][j]);
                 }
            }
        }
        return edge * edge;
    }
}
