package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-pruning/">Binary Tree Pruning</a>
 * <p>
 * Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * <p>
 * A subtree of a node node is node plus every node that is a descendant of node.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 200].</li>
 *  <li>Node.val is either 0 or 1.</li>
 * </ul>
 */
public class BinaryTreePruning {

    // O(N) time | O(N) space for the call stack, where N is the number of nodes in a tree
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    // Returns true, if the supplied tree contains 1
    private boolean containsOne(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean leftOk = containsOne(root.left);
        if (!leftOk) {
            // prune left subtree
            root.left = null;
        }

        boolean rightOk = containsOne(root.right);
        if (!rightOk) {
            // prune right subtree
            root.right = null;
        }

        return (root.val == 1) || leftOk || rightOk;
    }
}
