package com.geekuniversity.algorithm.homework.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给你一个二叉树，请你返回其按【层序遍历】得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 题解：
 * 1、广度优先搜索-BFS
 * 维护一个队列，通过每次遍历的节点放入队列中，队列不为空，分别取出放入层的节点，并且将节点的子节点重新放入队列。
 * 时间复杂度：O(N)，因为要遍历所有节点
 * 空间复杂度：O(N)，队列中的深度不超过节点数量
 *
 * 2、深度优先搜索-DFS
 * 通过【递归】的方式，进行深度优先遍历
 * 时间复杂度：O(N)，因为要遍历所有节点
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        // 广度优先搜索
        bfs(root, results);
        return results;
    }

    /**
     * 广度优先搜索，需要通过维护一个队列进行遍历
     */
    private void bfs(TreeNode root, List<List<Integer>> results) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 获取遍历层的节点数量
            int size = queue.size();
            List<Integer> visited = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visited.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            results.add(visited);
        }
    }

    /**
     * 【递归】方式深度优先，递归需要记录每一层的深度，然后重新遍历
     */
    private void dfsByRecursion(TreeNode root, int level, List<List<Integer>> results) {
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if (root.left != null) {
            dfsByRecursion(root.left, level + 1, results);
        }
        if (root.right != null) {
            dfsByRecursion(root.right, level + 1, results);
        }
    }

}