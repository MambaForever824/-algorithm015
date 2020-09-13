package com.geekuniversity.algorithm.homework.week3;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * Leetcode:https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1,
                 0, inorder.length - 1,
                inorderMap);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int inStart, int inEnd,
                              Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inorderMap.get(root.val);
        int left = inRoot - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + left, inStart, inRoot - 1, inorderMap);
        root.right = buildTree(preorder, preStart + left + 1, preEnd, inRoot + 1, inEnd, inorderMap);
        return root;
    }
}