package com.geekuniversity.algorithm.homework.week3;

/**
 * 二叉树的最近公共祖先
 * Leetcode： https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 如果 root为null，从首次遍历角度看，二叉树为null
 * 如果 root == p，则可认为 p 是 root节点，p和q的公共祖先就是 p
 * 同理，root == q，则可认为 q 是 root节点，p和q的公共祖先就是 q
 */
public class BinaryTreeLowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1、首先定义递归的终止条件
        //   当root为null，说明已遍历超过叶子节点，返回null
        //   当root为p或q，则返回root
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
