package com.geekuniversity.algorithm.homework.week2;

import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的前序遍历，给定一个 N 叉树，返回其节点值的前序遍历。
 * Leetcode: https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 * 前序遍历：中->左->右
 *
 * 解法思路：
 * 1、使用队列
 * 从根节点遍历所有子树，直到一棵子树遍历到叶子节点
 */
public class NTreePreorder {

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> results = new LinkedList<>();
        preorder(root, results);
        return results;
    }

    private void preorder(Node root, List<Integer> results) {
        results.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                preorder(node, results);
            }
        }
    }
}