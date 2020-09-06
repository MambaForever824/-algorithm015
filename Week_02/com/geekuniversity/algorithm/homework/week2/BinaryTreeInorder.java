package com.geekuniversity.algorithm.homework.week2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BinaryTreeInorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        inorder(root, results);
        return results;
    }

    private void inorder(TreeNode root, List<Integer> results) {
        if (root.left != null) {
            inorder(root.left, results);
        }
        results.add(root.val);
        if (root.right != null) {
            inorder(root.right, results);
        }
    }
}
