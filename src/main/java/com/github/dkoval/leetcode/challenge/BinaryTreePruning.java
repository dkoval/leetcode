package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3824/">Binary Tree Pruning</a>
 * <p>
 * Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * <p>
 * A subtree of a node node is node plus every node that is a descendant of node.
 */
public class BinaryTreePruning {

    // O(N) time | O(N) space for the call stack, where N is the number of nodes in a tree
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean leftContainsOne = containsOne(root.left);
        if (!leftContainsOne) {
            // prune left subtree
            root.left = null;
        }

        boolean rightContainsOne = containsOne(root.right);
        if (!rightContainsOne) {
            // prune right subtree
            root.right = null;
        }

        return (root.val == 1) || leftContainsOne || rightContainsOne;
    }
}
