package com.geekuniversity.algorithm.homework.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorder {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> results = new LinkedList<>();
        preorder(root, results);
        return results;
    }

    private void preorder(TreeNode root, List<Integer> results) {
        results.add(root.val);
        if (root.left != null) {
            preorder(root.left, results);
        }
        if (root.right != null) {
            preorder(root.right, results);
        }
    }
}
