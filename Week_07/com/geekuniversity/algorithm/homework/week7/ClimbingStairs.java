package com.geekuniversity.algorithm.homework.week7;

/**
 * 爬楼梯(https://leetcode-cn.com/problems/climbing-stairs/)
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 解题思路：
 * 1、动态规划
 * 2、数学方法
 */
public class ClimbingStairs {

    /**
     * 动态规划解题
     */
    public int climbStairs(int n) {
        int first = 0;
        int second = 0;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            first = second;
            second = result;
            result = first + second;
        }
        return result;
    }
}
