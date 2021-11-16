package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/subtree-of-another-tree/">Subtree of Another Tree</a>
 * <p>
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
 * structure and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree could also be considered as a subtree of itself.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the root tree is in the range [1, 2000]</li>
 *  <li>The number of nodes in the subRoot tree is in the range [1, 1000]</li>
 *  <li>-10^4 <= root.val <= 10^4</li>
 *  <li>-10^4 <= subRoot.val <= 10^4</li>
 * </ul>
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        return equals(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    private boolean equals(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        return (root.val == subRoot.val)
                && equals(root.left, subRoot.left)
                && equals(root.right, subRoot.right);
    }
}
