package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-tilt/">Binary Tree Tilt</a>
 * <p>
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 * <p>
 * The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values.
 * If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
 * The rule is similar if there the node does not have a right child.
 */
public class BinaryTreeTilt {

    private static class TreeInfo {
        final int sumOfNodes;
        final int sumOfTilts;

        TreeInfo(int sumOfNodes, int sumOfTilts) {
            this.sumOfNodes = sumOfNodes;
            this.sumOfTilts = sumOfTilts;
        }
    }

    // O(N) time | O(N) space
    public int findTilt(TreeNode root) {
        return doFindTilt(root).sumOfTilts;
    }

    private TreeInfo doFindTilt(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        // DFS - postorder
        TreeInfo left = doFindTilt(root.left);
        TreeInfo right = doFindTilt(root.right);
        return new TreeInfo(
                root.val + left.sumOfNodes + right.sumOfNodes,
                Math.abs(left.sumOfNodes - right.sumOfNodes) + left.sumOfTilts + right.sumOfTilts);
    }
}
