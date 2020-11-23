package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of Binary Tree</a>
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class DiameterOfBinaryTree {

    private static class TreeInfo {
        final int diameter;
        final int height; // number of nodes in a path

        TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root).diameter;
    }

    private TreeInfo dfs(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTreeInfo = dfs(root.left);
        TreeInfo rightTreeInfo = dfs(root.right);

        int currDiameter = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
        currDiameter = Math.max(currDiameter, leftTreeInfo.height + rightTreeInfo.height); // longest path through the root
        int currHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);
        return new TreeInfo(currDiameter, currHeight);
    }
}
