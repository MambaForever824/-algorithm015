package com.geekuniversity.algorithm.homework.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 * Leetcode: https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class NTreeLevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new LinkedList();
        }
        List<List<Integer>> results = new LinkedList();
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> values = new LinkedList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                values.add(node.val);
                queue.addAll(node.children);
            }
            results.add(values);
        }
        return results;
    }

}