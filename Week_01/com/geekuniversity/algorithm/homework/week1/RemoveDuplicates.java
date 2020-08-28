/**
 * 删除排序数组中的重复项
 * 给定一个排序数组，你需要在【原地】删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * LeetCode地址：
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * 解题思路
 * Q1: 如何知道哪些元素是重复的？
 * A1: 使用Map或Set存放已遍历的元素，如果已存在，代表是重复；
 * Q2: 如何返回新数组长度？
 * A2: 可以创建新的数组，用来存放【已遍历】【去重】元素，但是这不符合题目要求；
 * Q3: 如何去重？
 * A3: 将【重复元素】在数组中进行替换，当遍历到某个元素，发现不重复，则将元素插入数组第一个位置，继续遍历；
 *     如果遇到【重复元素】，则不进行插入；
 * Q4: 如何在原地修改？
 * A4: 记录第一个重复元素的位置，将后续遍历的元素与重复元素交换，需要两个指针，一个标记重复元素的位置，另一个用来遍历数组下标；
 *     联想到课上提到的双指针法，这道题目比较适合使用【快慢】指针，慢指针存放重复元素位置，快指针遍历数组；
 *
 * 相似题目参考：
 * 移动0，https://leetcode-cn.com/problems/move-zeroes/
 * 这道题目就是把0移动数组最后，可以把0理解为重复元素，将0和其他元素互换位置
 */
package com.geekuniversity.algorithm.homework.week1;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义Set存放已遍历的元素，并且作为判重依据
        Set<Integer> noRepeats = new HashSet<>();
        // 定义慢指针，用来记录当前重复元素位置；
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (!noRepeats.contains(nums[fast])) {
                // 如果元素不重复，代表当前元素可以在替换
                nums[slow] = nums[fast];
                // slow 要+1，当前元素不重复，看下一个是否重复
                slow++;
                // 当前元素存放在set中
                noRepeats.add(nums[fast]);
            }
        }
        // 返回slow的位置，代表元素中不重复的数量
        // 其实返回set的长度也可以
        return slow;
    }

}