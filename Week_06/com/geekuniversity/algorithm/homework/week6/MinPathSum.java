package com.geekuniversity.algorithm.homework.week6;

/**
 * 最小路径和(LeetCode：https://leetcode-cn.com/problems/minimum-path-sum/)
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class MinPathSum {

    /**
     * 此解法需要修改原来的二维数组
     */
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[rows - 1][columns - 1];
    }

    /**
     * 不需要修改原数组
     */
    public int minPathSum1(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[] dp = new int[columns];
        dp[0] = grid[0][0];
        for (int j = 1; j < columns; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == 0) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[columns - 1];
    }
}
