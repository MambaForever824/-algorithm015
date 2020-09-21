package com.geekuniversity.algorithm.homework.week4;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 在二叉树的每一行中找到最大的值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
 *
 * 解题思路:
 * 1、广度优先搜索BFS
 * 按层遍历，获取每层的节点，找出当前层中的最大值
 * 时间复杂度: O(N)
 * 空间复杂度: O(N)
 *
 * 2、深度优先搜索
 * 递归按层遍历，当某一层的首次访问，就把这个值放入列表，如果当前层的数据在列表中已存在，则比较当前值
 */
public class LargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = queue.peek().val;
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            results.add(max);
        }
        return results;
    }
}