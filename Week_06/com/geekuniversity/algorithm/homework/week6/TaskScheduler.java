package com.geekuniversity.algorithm.homework.week6;

/**
 * 任务调度器(https://leetcode-cn.com/problems/task-scheduler/)
 *
 * 给定一个用【字符数组】表示的 CPU 需要执行的任务列表。
 * 其中包含使用大写的 A - Z 字母表示的26种不同种类的任务。
 * 任务可以以【任意顺序】执行，并且每个任务都可以在 1 个单位时间内执行完。
 * CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * 然而，两个【相同种类】的任务之间必须有长度为 n 的冷却时间，
 * 因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 需要计算完成所有任务所需要的【最短】时间。
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTask = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTask);
        return tasks.length + idles;
    }

}
