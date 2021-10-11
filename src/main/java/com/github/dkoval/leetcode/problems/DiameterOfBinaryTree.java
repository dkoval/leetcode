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
        // The diameter of the bin tree, considering the current node as the root
        final int diameter;
        // The height of the bin tree (in number of nodes) at the current node, going bottom-up in the tree
        final int height;

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

        TreeInfo left = dfs(root.left);
        TreeInfo right = dfs(root.right);

        // option #1: path doesn't pass through the root node
        int diameter = Math.max(left.diameter, right.diameter);
        // option #2: path passes through the root node
        diameter = Math.max(diameter, left.height + right.height); // longest path through the root

        // now, compute the height of the root node
        int height = 1 + Math.max(left.height, right.height);
        return new TreeInfo(diameter, height);
    }
}
